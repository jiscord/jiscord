package site.lifix.jiscord.api.objects.guildscheduledevent;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildScheduledEventEntityMetadataObject extends BaseObject {
    // location of the event (1-100 characters)
    @Getter private final OptionalJsonValue<String> location
            = new OptionalJsonValue<>(this, "location", String.class);

    public GuildScheduledEventEntityMetadataObject(JsonElement dataIn) {
        super(dataIn);
    }

    public GuildScheduledEventEntityMetadataObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
