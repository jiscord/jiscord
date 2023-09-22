package site.lifix.jiscord.api.objects.gateway.events;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.easeofuse.JsonObjectEOU;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.channel.ChannelObject;
import site.lifix.jiscord.api.objects.gateway.GatewayApplicationObject;
import site.lifix.jiscord.api.objects.gateway.MergedPresencesObject;
import site.lifix.jiscord.api.objects.gateway.TutorialObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.api.objects.guild.GuildObject;
import site.lifix.jiscord.api.objects.presence.PresenceObject;
import site.lifix.jiscord.api.objects.user.ConnectionObject;
import site.lifix.jiscord.api.objects.user.RelationshipObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.api.objects.user.UserSettingsObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unused")
public class ReadyObject extends BaseObject {
    // Gateway Opcode, which indicates the payload type
    @Getter private final OptionalJsonValue<Integer> opcode
            = new OptionalJsonValue<>(this, "op", Integer.class);

    // Event data
    @Getter private final OptionalJsonValue<ReadyMessageData> eventData
            = new OptionalJsonValue<>(this, "d", ReadyMessageData.class);

    // Sequence number of event used for resuming sessions and heartbeating
    @Getter private final OptionalJsonValue<Integer> seqNum
            = new OptionalJsonValue<>(this, "s", Integer.class);

    // Event name for this payload (DISPATCH Opcode only)
    @Getter private final OptionalJsonValue<String> eventName
            = new OptionalJsonValue<>(this, "t", String.class);

    public ReadyObject(JsonElement data) {
        super(data);
    }

    public ReadyObject(OptionalJsonValue<?> data) {
        super(data);
    }

    public static class ReadyMessageData extends BaseObject {
        // API version
        @Getter private final OptionalJsonValue<Integer> apiVersion
                = new OptionalJsonValue<>(this, "v", Integer.class);

        // The connected user
        @Getter private final OptionalJsonValue<UserObject> user
                = new OptionalJsonValue<>(this, "user", UserObject.class);

        // The client settings for the user
        @Getter private final OptionalJsonValue<UserSettingsObject> userSettings
                = new OptionalJsonValue<>(this, "user_settings", UserSettingsObject.class);

        // The base-64 encoded preloaded user settings for the user, (if missing, defaults are used)
        @Getter private final OptionalJsonValue<String> userSettingsProto
                = new OptionalJsonValue<>(this, "user_settings_proto", String.class);

        // The guilds the user is in
        private final OptionalJsonValue<JsonArray> guilds
                = new OptionalJsonValue<>(this, "guilds", JsonArray.class);

        // The relationships the user has with other users
        private final OptionalJsonValue<JsonArray> relationships
                = new OptionalJsonValue<>(this, "relationships", JsonArray.class);

        // The number of friend suggestions the user has
        @Getter private final OptionalJsonValue<Integer> friendSuggestionCount
                = new OptionalJsonValue<>(this, "friend_suggestion_count", Integer.class);

        // The DMs and group DMs the user is participating in
        private final OptionalJsonValue<JsonArray> privateChannels
                = new OptionalJsonValue<>(this, "private_channels", JsonArray.class);

        // The third-party accounts the user has linked
        private final OptionalJsonValue<JsonArray> connectedAccounts
                = new OptionalJsonValue<>(this, "connected_accounts", JsonArray.class);

        // A mapping of user IDs to notes the user has made for them
        @Getter private final OptionalJsonValue<JsonObjectEOU> notes
                = new OptionalJsonValue<>(this, "notes", JsonObjectEOU.class);

        // The presences of the user's non-offline friends and implicit relationships (depending on the NO_AFFINE_USER_IDS Gateway capability).
        private final OptionalJsonValue<JsonArray> presences
                = new OptionalJsonValue<>(this, "presences", JsonArray.class);

        // The presences of the user's non-offline friends and implicit relationships (depending on the NO_AFFINE_USER_IDS Gateway capability), and any guild presences sent at startup
        @Getter private final OptionalJsonValue<MergedPresencesObject> mergedPresences
                = new OptionalJsonValue<>(this, "merged_presences", MergedPresencesObject.class);

        // The members of the user's guilds, in the same order as the guilds array
        private final OptionalJsonValue<JsonArray> mergedMembers
                = new OptionalJsonValue<>(this, "merged_members", JsonArray.class);

        // The deduped users across all objects in the event
        private final OptionalJsonValue<JsonArray> users
                = new OptionalJsonValue<>(this, "users", JsonArray.class);

        // The application of the connected user, if it is a bot
        @Getter private final OptionalJsonValue<GatewayApplicationObject> application
                = new OptionalJsonValue<>(this, "application", GatewayApplicationObject.class);

        // Unique session ID, used for resuming connections
        @Getter private final OptionalJsonValue<String> sessionId
                = new OptionalJsonValue<>(this, "session_id", String.class);

        // The type of session that was started
        @Getter private final OptionalJsonValue<String> sessionType
                = new OptionalJsonValue<>(this, "session_type", String.class);

        // The hash of the auth session ID corresponding to the auth token used to connect
        @Getter private final OptionalJsonValue<String> authSessionIdHash
                = new OptionalJsonValue<>(this, "auth_session_id_hash", String.class);

        // The refreshed auth token for this user; if present, the client should discard the current auth token and use this in subsequent requests to the API
        @Getter private final OptionalJsonValue<String> authToken
                = new OptionalJsonValue<>(this, "auth_token", String.class);

        // The token used for analytical tracking requests
        @Getter private final OptionalJsonValue<String> analyticsToken
                = new OptionalJsonValue<>(this, "analytics_token", String.class);

        // The action a user is required to take before continuing to use Discord
        @Getter private final OptionalJsonValue<String> requiredAction
                = new OptionalJsonValue<>(this, "required_action", String.class);

        // The detected ISO 3166-1 alpha-2 country code of the user's current IP address
        @Getter private final OptionalJsonValue<String> countryCode
                = new OptionalJsonValue<>(this, "country_code", String.class);

        // A geo-ordered list of RTC regions that can be used when when setting a voice channel's rtc_region or updating the client's voice state
        private final OptionalJsonValue<JsonArray> geoOrderedRtcRegions
                = new OptionalJsonValue<>(this, "geo_ordered_rtc_regions", JsonArray.class);

        // The tutorial state of the user, if any
        @Getter private final OptionalJsonValue<TutorialObject> tutorial
                = new OptionalJsonValue<>(this, "tutorial", TutorialObject.class);

        // The shard information (shard_id, num_shards) associated with this session, if sharded
        private final OptionalJsonValue<JsonArray> shard
                = new OptionalJsonValue<>(this, "shard", JsonArray.class);

        // WebSocket URL for resuming connections
        @Getter private final OptionalJsonValue<String> resumeGatewayUrl
                = new OptionalJsonValue<>(this, "resume_gateway_url", String.class);

        // The API code version, used when re-identifying with client state v2
        @Getter private final OptionalJsonValue<Integer> apiCodeVersion
                = new OptionalJsonValue<>(this, "api_code_version", Integer.class);

        // User experiment rollouts for the user
        private final OptionalJsonValue<JsonArray> experiments
                = new OptionalJsonValue<>(this, "experiments", JsonArray.class);

        // Guild experiment rollouts for the user
        private final OptionalJsonValue<JsonArray> guildExperiments
                = new OptionalJsonValue<>(this, "guild_experiments", JsonArray.class);

        public List<GuildObject> getGuilds() {
            return Utility.mappedJsonArray(this.guilds, GuildObject::new);
        }

        public List<RelationshipObject> getRelationships() {
            return Utility.mappedJsonArray(this.relationships, RelationshipObject::new);
        }

        public List<ChannelObject> getPrivateChannels() {
            return Utility.mappedJsonArray(this.privateChannels, ChannelObject::new);
        }

        public List<ConnectionObject> getConnectedAccounts() {
            return Utility.mappedJsonArray(this.connectedAccounts, ConnectionObject::new);
        }

        public List<PresenceObject> getPresences() {
            return Utility.mappedJsonArray(this.presences, PresenceObject::new);
        }

        public List<List<GuildMemberObject>> getMergedMembers() {
            List<List<GuildMemberObject>> all = new ArrayList<>();

            List<JsonArray> listOfArrays = Utility.mappedJsonArray(this.mergedMembers, JsonElement::getAsJsonArray);
            for (JsonArray array : listOfArrays) {
                all.add(Utility.mappedJsonArray(array, GuildMemberObject::new));
            }

            return all;
        }

        public List<UserObject> getUsers() {
            return Utility.mappedJsonArray(this.users, UserObject::new);
        }

        public ReadyMessageData(JsonElement data) {
            super(data);
        }

        public ReadyMessageData(OptionalJsonValue<?> data) {
            super(data);
        }
    }
}
