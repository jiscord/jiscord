package site.lifix.jiscord.api.objects.voice;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class VoiceStateObject extends BaseObject {
    // The guild ID this voice state is for
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The channel ID this user is connected to
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // The user ID this voice state is for
    @Getter private final OptionalJsonValue<String> userId
            = new OptionalJsonValue<>(this, "user_id", String.class);

    // The guild member this voice state is for
    @Getter private final OptionalJsonValue<GuildMemberObject> member
            = new OptionalJsonValue<>(this, "member", GuildMemberObject.class);

    // The session ID this voice state is from
    @Getter private final OptionalJsonValue<String> sessionId
            = new OptionalJsonValue<>(this, "session_id", String.class);

    // Whether this user is deafened by the guild, if any
    @Getter private final OptionalJsonValue<Boolean> deaf
            = new OptionalJsonValue<>(this, "deaf", Boolean.class);

    // Whether this user is muted by the guild, if any
    @Getter private final OptionalJsonValue<Boolean> mute
            = new OptionalJsonValue<>(this, "mute", Boolean.class);

    // Whether this user is locally deafened
    @Getter private final OptionalJsonValue<Boolean> selfDeaf
            = new OptionalJsonValue<>(this, "self_deaf", Boolean.class);

    // Whether this user is locally muted
    @Getter private final OptionalJsonValue<Boolean> selfMute
            = new OptionalJsonValue<>(this, "self_mute", Boolean.class);

    // Whether this user is streaming using "Go Live"
    @Getter private final OptionalJsonValue<Boolean> selfStream
            = new OptionalJsonValue<>(this, "self_stream", Boolean.class);

    // Whether this user's camera is enabled
    @Getter private final OptionalJsonValue<Boolean> selfVideo
            = new OptionalJsonValue<>(this, "self_video", Boolean.class);

    // Whether this user's permission to speak is denied
    @Getter private final OptionalJsonValue<Boolean> suppress
            = new OptionalJsonValue<>(this, "suppress", Boolean.class);

    // The time at which the user requested to speak
    @Getter private final OptionalJsonValue<String> requestToSpeakTimestamp
            = new OptionalJsonValue<>(this, "request_to_speak_timestamp", String.class);

    public VoiceStateObject(JsonElement dataIn) {
        super(dataIn);
    }

    public VoiceStateObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
