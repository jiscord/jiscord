package site.lifix.jiscord;

import com.google.gson.JsonElement;
import imgui.ImGui;
import imgui.ImGuiInputTextCallbackData;
import imgui.app.Application;
import imgui.app.Configuration;
import imgui.callback.ImGuiInputTextCallback;
import imgui.flag.ImGuiInputTextFlags;
import imgui.type.ImBoolean;
import imgui.type.ImString;
import site.lifix.jiscord.api.SocketClient;
import site.lifix.jiscord.api.easeofuse.JsonObjectEOU;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.impl.ChannelContentElement;
import site.lifix.jiscord.ui.elements.impl.ChannelListElement;
import site.lifix.jiscord.ui.elements.impl.ServerListElement;
import site.lifix.jiscord.ui.elements.impl.UserListElement;
import site.lifix.jiscord.ui.images.ImageCache;
import site.lifix.jiscord.ui.notifications.NotificationManager;
import site.lifix.jiscord.utility.CustomImGui;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    public static ServerListElement serverListElement = new ServerListElement();
    public static ChannelListElement channelListElement = new ChannelListElement();
    public static ChannelContentElement channelContentElement = new ChannelContentElement();
    public static UserListElement userListElement = new UserListElement();

    private static final ImString tokenInput = new ImString();

    public static ImBoolean printFullJsonMessages = new ImBoolean(false);

    private static void jsonTree(String name, JsonElement obj) {
        if (ImGui.treeNode(name)) {
            if (obj.isJsonObject()) {
                for (Map.Entry<String, JsonElement> elem : obj.getAsJsonObject().entrySet()) {
                    if (elem.getValue().isJsonObject()) {
                        jsonTree(elem.getKey(), elem.getValue());
                    } else if (elem.getValue().isJsonArray()) {
                        jsonTree(Utility.fmt("[{}]", elem.getKey()), elem.getValue());
                    } else {
                        ImGui.text("\"" + elem.getKey() + "\": " + elem.getValue());
                    }
                }
            } else if (obj.isJsonArray()) {
                int x = 0;
                for (JsonElement elem : obj.getAsJsonArray().asList()) {
                    if (elem.isJsonObject() || elem.isJsonArray()) {
                        jsonTree(String.valueOf(x), elem);
                    } else {
                        ImGui.text(x + ": " + elem);
                    }
                    x++;
                }
            }

            ImGui.treePop();
            ImGui.spacing();
        }
    }

    @Override
    protected void configure(Configuration config) {
        config.setTitle("Jiscord");
    }

    @Override
    protected void initImGui(final Configuration config) {
        super.initImGui(config);
        Fonts.onTick();
    }

    @Override
    public void process() {
        Renderer.BACKGROUND.rect(0.f, 0.f,
                ImGui.getIO().getDisplaySizeX(), ImGui.getIO().getDisplaySizeY(),
                Properties.backgroundColour);

        NotificationManager.onTick();

        serverListElement.render(Properties.Proportions.padding, Properties.Proportions.padding,
                Properties.Proportions.padding + Properties.Proportions.guildListWidth,
                ImGui.getIO().getDisplaySizeY() - Properties.Proportions.padding,
                ImGui.getIO());

        channelListElement.render(
                Properties.Proportions.padding * 2 + Properties.Proportions.guildListWidth,
                Properties.Proportions.padding,
                Properties.Proportions.padding * 2 + Properties.Proportions.guildListWidth
                        + Properties.Proportions.channelListWidth,
                ImGui.getIO().getDisplaySizeY() - Properties.Proportions.padding,
                ImGui.getIO());

        channelContentElement.render(
                Properties.Proportions.padding * 3 + Properties.Proportions.guildListWidth
                        + Properties.Proportions.channelListWidth,
                Properties.Proportions.padding,
                ImGui.getIO().getDisplaySizeX() - Properties.Proportions.padding * 2
                        - Properties.Proportions.userListWidth,
                ImGui.getIO().getDisplaySizeY() - Properties.Proportions.padding,
                ImGui.getIO());

        userListElement.render(
                ImGui.getIO().getDisplaySizeX() - Properties.Proportions.padding
                        - Properties.Proportions.userListWidth,
                Properties.Proportions.padding,
                ImGui.getIO().getDisplaySizeX() - Properties.Proportions.padding,
                ImGui.getIO().getDisplaySizeY() - Properties.Proportions.padding,
                ImGui.getIO());

        ImGui.text("Hello, World!");

        CustomImGui.titledGroup("Debug", () -> {
            if (ImGui.button("Short notification")) {
                NotificationManager.push("Short notification", "Content here");
            }

            if (ImGui.button("Long notification")) {
                NotificationManager.push("Long notification", "Lorem ipsum dolor sit amet, " +
                        " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim" +
                        " ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
                        " consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
                        " fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui" +
                        " officia deserunt mollit anim id est laborum.");
            }

            ImGui.checkbox("Print full JSON data on message", printFullJsonMessages);
        });

        CustomImGui.titledGroup("Login", () -> {
            if (ImGui.inputText("Token input (enter to login)", tokenInput, ImGuiInputTextFlags.EnterReturnsTrue)) {
                if (tokenInput.get().length() > 60) {
                    SocketClient.launch(tokenInput.get());
                }
            }
        });

        CustomImGui.titledGroup("Packets", () -> {
            if (ImGui.collapsingHeader("Packets sent")) {
                List<JsonObjectEOU> safePacketList = new ArrayList<>(SocketClient.sentPacketList);

                int x = 1;
                for (JsonObjectEOU obj : safePacketList) {
                    String name = "Packet #";
                    name += x;
                    if (obj.has("op") || obj.has("t")) {
                        int op = obj.get("op", Integer.class, -1);
                        name += " (Opcode: ";
                        name += Utility.namedGatewayOpcode(op);
                        name += ")";
                    }
                    jsonTree(name, obj.getNativeObject());
                    x++;
                }
            }

            if (ImGui.collapsingHeader("Packets received")) {
                List<JsonObjectEOU> safePacketList = new ArrayList<>(SocketClient.packetList);

                int x = 1;
                for (JsonObjectEOU obj : safePacketList) {
                    String name = "Packet #";
                    name += x;
                    if (obj.has("op") || obj.has("t")) {
                        int op = obj.get("op", Integer.class, -1);
                        String t = obj.get("t", String.class, "None");
                        name += " (Opcode: ";
                        name += Utility.namedGatewayOpcode(op);
                        name += ", Type: ";
                        name += t;
                        name += ")";
                    }
                    jsonTree(name, obj.getNativeObject());
                    x++;
                }
            }
        });
    }

    @Override
    protected void dispose() {
        super.dispose();
        if (SocketClient.instance != null && SocketClient.instance.isOpen()) {
            SocketClient.instance.close();
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        ImageCache.startImageRefreshThread();
        launch(new Main());
    }
}