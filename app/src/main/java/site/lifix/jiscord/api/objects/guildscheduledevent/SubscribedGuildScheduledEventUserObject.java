package site.lifix.jiscord.api.objects.guildscheduledevent;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class SubscribedGuildScheduledEventUserObject extends BaseObject {
    // The ID of the scheduled event the user subscribed to
    @Getter private final OptionalJsonValue<String> guildScheduledEventId
            = new OptionalJsonValue<>(this, "guild_scheduled_event_id", String.class);

    // The ID of the user that subscribed to the scheduled event
    @Getter private final OptionalJsonValue<String> userId
            = new OptionalJsonValue<>(this, "user_id", String.class);

    public SubscribedGuildScheduledEventUserObject(JsonElement dataIn) {
        super(dataIn);
    }

    public SubscribedGuildScheduledEventUserObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
