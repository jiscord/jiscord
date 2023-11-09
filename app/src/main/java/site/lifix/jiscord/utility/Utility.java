package site.lifix.jiscord.utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import site.lifix.jiscord.api.SocketClient;
import site.lifix.jiscord.api.statics.gateway.Capabilities;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Utility {
    public static int getCapabilities() {
        return Capabilities.VERSIONED_READ_STATES
                | Capabilities.VERSIONED_USER_GUILD_SETTINGS | Capabilities.DEDUPE_USER_OBJECTS
                | Capabilities.PRIORITIZED_READY_PAYLOAD | Capabilities.MULTIPLE_GUILD_EXPERIMENT_POPULATIONS;
    }

    public static URLConnection properConnection(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Accept-Language", "en-US,en;q=0.9");
        connection.addRequestProperty("Cache-Control", "no-cache");
        connection.addRequestProperty("Pragma", "no-cache");
        connection.addRequestProperty("Sec-WebSocket-Extensions", "permessage-deflate;" +
                " client_max_window_bits");
        connection.addRequestProperty("User-Agent", "Mozilla/5.0" +
                " (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/605.1.15 (KHTML, like Gecko)" +
                " Version/13.1.2 Safari/605.1.15");

        return connection;
    }

    public static URLConnection properConnectionAuthorized(URL url) throws IOException {
        URLConnection connection = properConnection(url);
        connection.addRequestProperty("Authorization", SocketClient.instance.getToken());
        return connection;
    }

    public static String fmt(String text, Object... objects) {
        String finalText = text;
        for (int x = 0; x < objects.length; x++) {
            finalText = finalText.replaceFirst("\\{}", objects[x].toString());
            finalText = finalText.replaceAll("\\{" + x + "}", objects[x].toString());
        }

        return finalText;
    }

    public static byte[] fileToByteArray(String file) {
        try (InputStream stream = Utility.class.getClassLoader().getResourceAsStream(file)) {
            if (stream != null) {
                byte[] targetArray = new byte[stream.available()];
                stream.read(targetArray);
                return targetArray;
            }
        } catch (Exception e) {
            // todo: make popup
            e.printStackTrace();
        }

        return new byte[0];
    }

    public static byte[] connectionToByteArray(URLConnection connection) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            try (InputStream is = connection.getInputStream()) {
                byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
                int n;

                while ((n = is.read(byteChunk)) > 0) {
                    output.write(byteChunk, 0, n);
                }

                return output.toByteArray();
            } catch (IOException e) {
                System.err.printf("Failed while reading bytes from %s: %s", connection.getURL().toExternalForm(),
                        e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public static String connectionToString(URLConnection connection) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder builder = new StringBuilder();
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    builder.append(inputLine).append("\n");
                }
                reader.close();
                return builder.substring(0, builder.length() - 1);
            } catch (IOException e) {
                System.err.printf("Failed while reading bytes from %s: %s", connection.getURL().toExternalForm(),
                        e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static byte[] urlToByteArray(String url) {
        System.out.println("Requesting bytes from \"" + url + "\"...");
        try {
            return connectionToByteArray(properConnection(new URL(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public static byte[] urlToByteArrayAuthorized(String url) {
        System.out.println("Requesting bytes from \"" + url + "\" (authorized)...");
        try {
            return connectionToByteArray(properConnectionAuthorized(new URL(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public static String urlToString(String url) {
        System.out.println("Requesting string from \"" + url + "\"...");
        try {
            return connectionToString(properConnection(new URL(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String urlToStringAuthorized(String url) {
        System.out.println("Requesting string from \"" + url + "\" (authorized)...");
        try {
            return connectionToString(properConnectionAuthorized(new URL(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @SafeVarargs
    public static <T> boolean is(T value, T... matches) {
        for (T match : matches) {
            if (value == match) {
                return true;
            }
        }

        return false;
    }

    public static boolean classEq(Class<?> classOne, Class<?> classTwo) {
        return classOne.getCanonicalName().equals(classTwo.getCanonicalName());
    }

    public static String namedGatewayOpcode(int op) {
        switch (op) {
            case 0:
                return fmt("Dispatch [{}]", op);
            case 1:
                return fmt("Heartbeat [{}]", op);
            case 2:
                return fmt("Identify [{}]", op);
            case 3:
                return fmt("Presence update [{}]", op);
            case 4:
                return fmt("Voice state update [{}]", op);
            case 6:
                return fmt("Resume [{}]", op);
            case 7:
                return fmt("Reconnect [{}]", op);
            case 8:
                return fmt("Request guild members [{}]", op);
            case 9:
                return fmt("Session invalidated [{}]", op);
            case 10:
                return fmt("Hello [{}]", op);
            case 11:
                return fmt("Heartbeat acknowledgement [{}]", op);
        }

        return fmt("Unknown [{}]", op);
    }

    public static Color applyOpacity(Color color, int opacity) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity);
    }

    public static int positiveDiff(int a, int b) {
        return Math.max(a, b) - Math.min(a, b);
    }

    public static long positiveDiff(long a, long b) {
        return Math.max(a, b) - Math.min(a, b);
    }

    public static float positiveDiff(float a, float b) {
        return Math.max(a, b) - Math.min(a, b);
    }

    public static <A, B> List<A> copyModified(Collection<B> originalList, CustomRunnable<A, B> conversion) {
        List<A> list = new ArrayList<>();
        if (originalList != null && !originalList.isEmpty()) {
            for (B item : originalList) {
                list.add(conversion.run(item));
            }
        }

        return list;
    }

    public static <A, B> List<A> copyModified(B[] originalList, CustomRunnable<A, B> conversion) {
        return copyModified(Arrays.asList(originalList), conversion);
    }

    public static <T> List<T> mappedJsonArray(JsonElement array, CustomRunnable<T, JsonElement> conversion) {
        List<T> list = new ArrayList<>();
        if (array != null && !array.isJsonNull() && array.isJsonArray()) {
            JsonArray jsonArray = array.getAsJsonArray();
            for (JsonElement item : jsonArray.asList()) {
                if (!item.isJsonNull()) {
                    list.add(conversion.run(item));
                }
            }
        }

        return list;
    }

    public static <T> List<T> mappedJsonArray(OptionalJsonValue<JsonArray> array,
                                              CustomRunnable<T, JsonElement> conversion) {
        if (array.existsNonNull()) {
            return mappedJsonArray(array.get(), conversion);
        } else {
            return new ArrayList<>();
        }
    }
}
