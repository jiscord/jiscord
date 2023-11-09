package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildWidgetMemberObject extends BaseObject {
    // The primary activity the member is participating in
    @Getter private final OptionalJsonValue<GuildWidgetMemberActivityObject> activity
            = new OptionalJsonValue<>(this, "activity", GuildWidgetMemberActivityObject.class);

    // The avatar URL of the member
    @Getter private final OptionalJsonValue<String> avatarUrl
            = new OptionalJsonValue<>(this, "avatar_url", String.class);

    // The ID of the voice or stage channel the member is in
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // Whether the member is deafened by the guild, if any
    @Getter private final OptionalJsonValue<Boolean> deaf
            = new OptionalJsonValue<>(this, "deaf", Boolean.class);

    // The incrementing ID of the member
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // Whether the member is muted by the guild, if any
    @Getter private final OptionalJsonValue<Boolean> mute
            = new OptionalJsonValue<>(this, "mute", Boolean.class);

    // Whether the member is locally deafened
    @Getter private final OptionalJsonValue<Boolean> selfDeaf
            = new OptionalJsonValue<>(this, "self_deaf", Boolean.class);

    // Whether the member is locally muted
    @Getter private final OptionalJsonValue<Boolean> selfMute
            = new OptionalJsonValue<>(this, "self_mute", Boolean.class);

    // The status of the member
    @Getter private final OptionalJsonValue<String> status
            = new OptionalJsonValue<>(this, "status", String.class);

    // Whether the member's permission to speak is denied
    @Getter private final OptionalJsonValue<Boolean> suppress
            = new OptionalJsonValue<>(this, "suppress", Boolean.class);

    // The username of the member
    @Getter private final OptionalJsonValue<String> username
            = new OptionalJsonValue<>(this, "username", String.class);

    public GuildWidgetMemberObject(JsonElement data) {
        super(data);
    }

    public GuildWidgetMemberObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
