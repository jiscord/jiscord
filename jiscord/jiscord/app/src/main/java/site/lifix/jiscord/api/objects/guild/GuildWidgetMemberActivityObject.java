package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildWidgetMemberActivityObject extends BaseObject {
    // The name of the activity
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    public GuildWidgetMemberActivityObject(JsonElement data) {
        super(data);
    }

    public GuildWidgetMemberActivityObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
