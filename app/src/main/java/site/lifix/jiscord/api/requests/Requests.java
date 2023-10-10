package site.lifix.jiscord.api.requests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import site.lifix.jiscord.api.easeofuse.JsonArrayEOU;
import site.lifix.jiscord.api.easeofuse.JsonObjectEOU;
import site.lifix.jiscord.api.objects.channel.ChannelObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Requests {
    public static class QueryStringParameters {
        private final Map<String, String> parameters = new HashMap<>();

        public QueryStringParameters add(String parameter, Object value) {
            if (value != null) {
                this.parameters.put(parameter, value.toString());
            }
            return this;
        }

        public QueryStringParameters remove(String parameter) {
            this.parameters.remove(parameter);
            return this;
        }

        public String toString() {
            if (this.parameters.isEmpty()) {
                return "";
            }

            StringBuilder builder = new StringBuilder("?");
            for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
                String parameter = entry.getKey();
                String value = entry.getValue();

                if (builder.length() > 1) {
                    builder.append("&");
                }

                builder.append(parameter)
                        .append("=")
                        .append(value);
            }

            return builder.toString();
        }
    }

    public static class Endpoints {
        private static final String BASE_URL = "https://discordapp.com/api";

        private static String createUrl(QueryStringParameters parameters, Object... paths) {
            StringBuilder finalUrl = new StringBuilder(BASE_URL);
            for (Object path : paths) {
                finalUrl.append("/").append(path.toString());
            }

            if (parameters != null) {
                finalUrl.append(parameters);
            }

            return finalUrl.toString();
        }

        public static class GET {
            public static String getLatestApplicationInstaller(String releaseChannel, String platform, String format) {
                return createUrl(new QueryStringParameters()
                                .add("platform", platform)
                                .add("format", format),
                        "download", releaseChannel);
            }

            public static String getApplicationUpdates(String releaseChannel, String platform) {
                return createUrl(new QueryStringParameters()
                                .add("platform", platform),
                        "updates", releaseChannel);
            }

            public static String getNativeModuleVersions(String releaseChannel, String platform, String hostVersion) {
                return createUrl(new QueryStringParameters()
                                .add("platform", platform)
                                .add("host_version", hostVersion),
                        "modules", releaseChannel, "versions.json");
            }

            public static String getNativeModule(String releaseChannel, String moduleName, String moduleVersion,
                                                 String platform, String hostVersion) {
                return createUrl(new QueryStringParameters()
                                .add("platform", platform)
                                .add("host_version", hostVersion),
                        "modules", releaseChannel, moduleName, moduleVersion);
            }

            public static String getLatestDistributedApplicationInstaller(String channel, String platform,
                                                                          String arch) {
                return createUrl(new QueryStringParameters()
                                .add("channel", channel)
                                .add("platform", platform)
                                .add("arch", arch),
                        "downloads", "distributions", "app", "installers", "latest");
            }

            public static String getLatestDistributedApplicationManifest(String channel, String platform,
                                                                         String arch) {
                return createUrl(new QueryStringParameters()
                                .add("channel", channel)
                                .add("platform", platform)
                                .add("arch", arch),
                        "updates", "distributions", "app", "manifests", "latest");
            }

            public static String getGuildIntegrations(String guildId, boolean hasCommands,
                                                      boolean includeRoleConnectionsMetadata) {
                return createUrl(new QueryStringParameters()
                                .add("has_commands", hasCommands ? "true" : "false")
                                .add("include_role_connections_metadata", includeRoleConnectionsMetadata
                                        ? "true" : "false"),
                        "guilds", guildId, "integrations");
            }

            public static String getPrivateChannels() {
                return createUrl(new QueryStringParameters(),
                        "v8", "users", "@me", "channels");
            }
        }
    }

    public static List<ChannelObject> getPrivateChannels() {
        String raw = Utility.urlToStringAuthorized(Endpoints.GET.getPrivateChannels());

        if (!raw.isEmpty()) {
            JsonElement elem = JsonParser.parseString(raw);
            if (elem.isJsonArray()) {
                return Utility.mappedJsonArray(elem.getAsJsonArray(), ChannelObject::new);
            }
        }

        return new ArrayList<>();
    }
}
