package site.lifix.jiscord.api.objects.gateway;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.channel.ChannelObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.api.objects.guild.GuildObject;
import site.lifix.jiscord.api.objects.guild.permissions.RoleObject;
import site.lifix.jiscord.api.objects.guildscheduledevent.GuildScheduledEventObject;
import site.lifix.jiscord.api.objects.presence.PresenceObject;
import site.lifix.jiscord.api.objects.stageinstance.StageInstanceObject;
import site.lifix.jiscord.api.objects.sticker.StickerObject;
import site.lifix.jiscord.api.objects.voice.VoiceStateObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class GatewayGuildObject extends BaseObject {
    // When this guild was joined
    @Getter private final OptionalJsonValue<String> joinedAt
            = new OptionalJsonValue<>(this, "joined_at", String.class);

    // Whether this is considered a large guild
    @Getter private final OptionalJsonValue<Boolean> large
            = new OptionalJsonValue<>(this, "large", Boolean.class);

    // Whether this guild is unavailable due to an outage
    @Getter private final OptionalJsonValue<Boolean> unavailable
            = new OptionalJsonValue<>(this, "unavailable", Boolean.class);

    // Total number of members in this guild
    @Getter private final OptionalJsonValue<Integer> memberCount
            = new OptionalJsonValue<>(this, "member_count", Integer.class);

    // States of members currently in voice channels
    private final OptionalJsonValue<JsonArray> voiceStates
            = new OptionalJsonValue<>(this, "voice_states", JsonArray.class);

    // Members in the guild
    private final OptionalJsonValue<JsonArray> members
            = new OptionalJsonValue<>(this, "members", JsonArray.class);

    // Channels in the guild
    private final OptionalJsonValue<JsonArray> channels
            = new OptionalJsonValue<>(this, "channels", JsonArray.class);

    // All active threads in the guild that current user has permission to view
    private final OptionalJsonValue<JsonArray> threads
            = new OptionalJsonValue<>(this, "threads", JsonArray.class);

    // Presences of included guild members; will only include non-offline members for large guilds
    private final OptionalJsonValue<JsonArray> presences
            = new OptionalJsonValue<>(this, "presences", JsonArray.class);

    // Stage instances in the guild
    private final OptionalJsonValue<JsonArray> stageInstances
            = new OptionalJsonValue<>(this, "stage_instances", JsonArray.class);

    // Scheduled events in the guild
    private final OptionalJsonValue<JsonArray> guildScheduledEvents
            = new OptionalJsonValue<>(this, "guild_scheduled_events", JsonArray.class);

    // The data mode for this object
    @Getter private final OptionalJsonValue<String> dataMode
            = new OptionalJsonValue<>(this, "data_mode", String.class);

    // The properties of the guild; an otherwise-normal guild object that is missing the below fields
    @Getter private final OptionalJsonValue<GuildObject> properties
            = new OptionalJsonValue<>(this, "properties", GuildObject.class);

    // Custom guild stickers
    private final OptionalJsonValue<JsonArray> stickers
            = new OptionalJsonValue<>(this, "stickers", JsonArray.class);

    // Roles in the guild
    private final OptionalJsonValue<JsonArray> roles
            = new OptionalJsonValue<>(this, "roles", JsonArray.class);

    // Custom guild emojis
    private final OptionalJsonValue<JsonArray> emojis
            = new OptionalJsonValue<>(this, "emojis", JsonArray.class);

    // The number of boosts this guild currently has
    @Getter private final OptionalJsonValue<Integer> premiumSubscriptionCount
            = new OptionalJsonValue<>(this, "premium_subscription_count", Integer.class);

    public List<VoiceStateObject> getVoiceStates() {
        return Utility.mappedJsonArray(this.voiceStates, VoiceStateObject::new);
    }

    public List<GuildMemberObject> getMembers() {
        return Utility.mappedJsonArray(this.members, GuildMemberObject::new);
    }

    public List<ChannelObject> getChannels() {
        return Utility.mappedJsonArray(this.channels, ChannelObject::new);
    }

    public List<ChannelObject> getThreads() {
        return Utility.mappedJsonArray(this.threads, ChannelObject::new);
    }

    public List<PresenceObject> getPresences() {
        return Utility.mappedJsonArray(this.presences, PresenceObject::new);
    }

    public List<StageInstanceObject> getStageInstances() {
        return Utility.mappedJsonArray(this.stageInstances, StageInstanceObject::new);
    }

    public List<GuildScheduledEventObject> getGuildScheduledEvents() {
        return Utility.mappedJsonArray(this.guildScheduledEvents, GuildScheduledEventObject::new);
    }

    public List<StickerObject> getStickers() {
        return Utility.mappedJsonArray(this.stickers, StickerObject::new);
    }

    public List<RoleObject> getRoles() {
        return Utility.mappedJsonArray(this.roles, RoleObject::new);
    }

    public List<EmojiObject> getEmojis() {
        return Utility.mappedJsonArray(this.emojis, EmojiObject::new);
    }

    public GatewayGuildObject(JsonElement dataIn) {
        super(dataIn);
    }

    public GatewayGuildObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
