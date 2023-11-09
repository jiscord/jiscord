package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ThreadMemberObject extends BaseObject {
    // The user's thread flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // The ID of the thread
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The time the current user last joined the thread
    @Getter private final OptionalJsonValue<String> joinTimestamp
            = new OptionalJsonValue<>(this, "join_timestamp", String.class);

    // The member object for the user
    @Getter private final OptionalJsonValue<GuildMemberObject> member
            = new OptionalJsonValue<>(this, "member", GuildMemberObject.class);

    // Whether the user has muted the thread
    @Getter private final OptionalJsonValue<Boolean> muted
            = new OptionalJsonValue<>(this, "muted", Boolean.class);

    // The ID of the user
    @Getter private final OptionalJsonValue<String> userId
            = new OptionalJsonValue<>(this, "user_id", String.class);

    public ThreadMemberObject(JsonElement data) {
        super(data);
    }

    public ThreadMemberObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
