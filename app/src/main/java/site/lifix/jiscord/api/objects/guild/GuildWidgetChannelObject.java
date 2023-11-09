package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildWidgetChannelObject extends BaseObject {
    // The ID of the channel
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the channel (1-100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Sorting position of the channel
    @Getter private final OptionalJsonValue<Integer> position
            = new OptionalJsonValue<>(this, "position", Integer.class);

    public GuildWidgetChannelObject(JsonElement data) {
        super(data);
    }

    public GuildWidgetChannelObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
