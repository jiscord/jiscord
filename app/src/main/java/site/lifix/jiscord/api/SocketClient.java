package site.lifix.jiscord.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import site.lifix.jiscord.api.easeofuse.JsonObjectEOU;
import site.lifix.jiscord.api.objects.gateway.events.ReadyObject;
import site.lifix.jiscord.api.objects.guild.GuildObject;
import site.lifix.jiscord.ui.elements.impl.ServerListElement;
import site.lifix.jiscord.ui.notifications.NotificationManager;
import site.lifix.jiscord.utility.Utility;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocketClient extends WebSocketClient {
    private int packetsReceived = 0;
    public static List<JsonObjectEOU> packetList = new ArrayList<>();
    public static List<JsonObjectEOU> sentPacketList = new ArrayList<>();
    public static SocketClient instance;

    private String token;

    public SocketClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public SocketClient(URI serverURI) {
        super(serverURI);
    }

    public SocketClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public static void launch(String token) {
        new Thread(() -> {
            try {
                SocketClient.instance = new SocketClient(new URI("wss://gateway.discord.gg/?encoding=json&v=9"));
                SocketClient.instance.token = token;
                SocketClient.instance.addHeader("Accept-Encoding", "gzip, deflate, br");
                SocketClient.instance.addHeader("Accept-Language", "en-US,en;q=0.9");
                SocketClient.instance.addHeader("Cache-Control", "no-cache");
                SocketClient.instance.addHeader("Pragma", "no-cache");
                SocketClient.instance.addHeader("Sec-WebSocket-Extensions", "permessage-deflate;" +
                        " client_max_window_bits");
                SocketClient.instance.addHeader("User-Agent", "Mozilla/5.0" +
                        " (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/605.1.15 (KHTML, like Gecko)" +
                        " Version/13.1.2 Safari/605.1.15");
                SocketClient.instance.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void onOpen(ServerHandshake handshakeData) {
        NotificationManager.push("Socket", "Socket opened.");
        JsonObjectEOU handshakePacket = new JsonObjectEOU()
                .add("op", 2)
                .add("d", new JsonObjectEOU()
                        .add("token", this.token)
                        .add("capabilities", Utility.getCapabilities())
                        .add("properties", new JsonObjectEOU()
                                .add("os", "Windows")
                                .add("browser", "Firefox")
                                .add("device", "")
                                .add("system_locale", "it-IT")
                                .add("browser_user_agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:94.0)" +
                                        " Gecko/20100101 Firefox/94.0")
                                .add("browser_version", "94.0")
                                .add("os_version", "10")
                                .add("referrer", "")
                                .add("referring_domain", "")
                                .add("referrer_current", "")
                                .add("referring_domain_current", "")
                                .add("release_channel", "stable")
                                .add("client_build_number", 103981)
                                .add("client_event_source", null))
                        .add("presence", new JsonObjectEOU()
                                .add("status", "online")
                                .add("since", "0")
                                .add("activities", new JsonArray())
                                .add("afk", false))
                        .add("compress", false)
                        .add("client_state", new JsonObjectEOU()
                                .add("guild_hashes", new JsonObjectEOU())
                                .add("highest_last_message_id", "0")
                                .add("read_state_version", 0)
                                .add("user_guild_settings_version", -1)
                                .add("user_settings_version", -1)));

        sentPacketList.add(handshakePacket);
        this.send(handshakePacket.string());
        System.out.println("opened connection");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage(String message) {
        JsonObject obj = JsonParser.parseString(message).getAsJsonObject();
        packetList.add(new JsonObjectEOU(obj));

        if (obj.has("op")) {
            int op = obj.get("op").getAsInt();
            if (op != 11) {
                this.packetsReceived += 1;
            }

            if (op == 10) {
                int heartbeatInterval = obj.get("d").getAsJsonObject().get("heartbeat_interval").getAsInt();
                new Thread(() -> {
                    try {
                        while (this.isOpen()) {
                            System.out.println("Sending heartbeat after " + (heartbeatInterval / 1000) + " seconds");
                            JsonObjectEOU heartbeatPacket = new JsonObjectEOU()
                                    .add("op", 1)
                                    .add("d", this.packetsReceived);
                            sentPacketList.add(heartbeatPacket);
                            this.send(heartbeatPacket.string());

                            Thread.sleep(heartbeatInterval);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }

        if (obj.has("t") && !obj.get("t").isJsonNull()) {
            if (obj.get("t").getAsString().equalsIgnoreCase("message_create")) {
                String author = "Unknown";
                String content = "None";
                try {
                    author = obj.get("d").getAsJsonObject().get("author").getAsJsonObject().get("username")
                            .getAsString();
                } catch (Exception ignored) {}

                try {
                    content = obj.get("d").getAsJsonObject().get("content").getAsString();
                } catch (Exception ignored) {}

                NotificationManager.push(author, content);
            } else if (obj.get("t").getAsString().equalsIgnoreCase("ready")) {
                ReadyObject ready = new ReadyObject(obj);

                if (ready.getEventData().exists()) {
                    ReadyObject.ReadyMessageData data = ready.getEventData().get();
                    List<GuildObject> guilds = data.getGuilds();

                    if (guilds != null) {
                        guilds.forEach((guild) -> {
                            System.out.println("aa");
                            NotificationManager.push("Found guild", guild.getName().get());
                            ServerListElement.partialGuilds.add(guild);
                        });
                    }
                }
            }
        }

        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        NotificationManager.push("Socket", "Socket closed.");
        // The close codes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println("Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
                        + reason);
        //packetList.clear();
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }
}