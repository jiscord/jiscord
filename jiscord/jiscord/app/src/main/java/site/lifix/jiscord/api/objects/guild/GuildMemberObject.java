package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class GuildMemberObject extends BaseObject {
    // The member's guild avatar hash
    @Getter private final OptionalJsonValue<String> avatar
            = new OptionalJsonValue<>(this, "avatar", String.class);

    // When the member's timeout will expire and they will be able to communicate in the guild again
    @Getter private final OptionalJsonValue<String> communicationDisabledUntil
            = new OptionalJsonValue<>(this, "communication_disabled_until", String.class);

    // Whether the member is deafened in voice channels
    @Getter private final OptionalJsonValue<Boolean> deaf
            = new OptionalJsonValue<>(this, "deaf", Boolean.class);

    // The member's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // When the user joined the guild
    @Getter private final OptionalJsonValue<String> joinedAt
            = new OptionalJsonValue<>(this, "joined_at", String.class);

    // Whether the member is muted in voice channels
    @Getter private final OptionalJsonValue<Boolean> mute
            = new OptionalJsonValue<>(this, "mute", Boolean.class);

    // The guild-specific nickname of the member (1-32 characters)
    @Getter private final OptionalJsonValue<String> nick
            = new OptionalJsonValue<>(this, "nick", String.class);

    // Whether the member has not yet passed the guild's membership screening requirements
    @Getter private final OptionalJsonValue<Boolean> pending
            = new OptionalJsonValue<>(this, "pending", Boolean.class);

    // Total permissions of the member in the channel, including overwrites
    @Getter private final OptionalJsonValue<String> permissions
            = new OptionalJsonValue<>(this, "permissions", String.class);

    // When the member subscribed to (started boosting) the guild
    @Getter private final OptionalJsonValue<String> premiumSince
            = new OptionalJsonValue<>(this, "premium_since", String.class);

    // The role IDs assigned to this member
    private final OptionalJsonValue<JsonArray> roles
            = new OptionalJsonValue<>(this, "roles", JsonArray.class);

    // The user this guild member represents
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    public List<String> getRoles() {
        return Utility.mappedJsonArray(this.roles, JsonElement::getAsString);
    }

    public GuildMemberObject(JsonElement data) {
        super(data);
    }

    public GuildMemberObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
