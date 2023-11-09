package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ActivityEmojiObject extends BaseObject {
    // The name of the emoji
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The ID of the emoji
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // Whether this emoji is animated
    @Getter private final OptionalJsonValue<Boolean> animated
            = new OptionalJsonValue<>(this, "animated", Boolean.class);

    public ActivityEmojiObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivityEmojiObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
