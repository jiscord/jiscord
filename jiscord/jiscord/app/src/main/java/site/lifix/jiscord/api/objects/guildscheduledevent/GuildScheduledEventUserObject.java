package site.lifix.jiscord.api.objects.guildscheduledevent;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.guild.GuildMemberObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildScheduledEventUserObject extends BaseObject {
    // The ID of the scheduled event the user subscribed to
    @Getter private final OptionalJsonValue<String> guildScheduledEventId
            = new OptionalJsonValue<>(this, "guild_scheduled_event_id", String.class);

    // The user that subscribed to the scheduled event
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    // Guild member data for the user in the scheduled event's guild, if any
    @Getter private final OptionalJsonValue<GuildMemberObject> member
            = new OptionalJsonValue<>(this, "member", GuildMemberObject.class);

    public GuildScheduledEventUserObject(JsonElement dataIn) {
        super(dataIn);
    }

    public GuildScheduledEventUserObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
