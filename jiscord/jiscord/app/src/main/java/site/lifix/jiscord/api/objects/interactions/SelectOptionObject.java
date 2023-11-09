package site.lifix.jiscord.api.objects.interactions;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class SelectOptionObject extends BaseObject {
    // the user-facing name of the option, max 100 characters
    @Getter private final OptionalJsonValue<String> label
            = new OptionalJsonValue<>(this, "label", String.class);

    // the dev-define value of the option, max 100 characters
    @Getter private final OptionalJsonValue<String> value
            = new OptionalJsonValue<>(this, "value", String.class);

    // an additional description of the option, max 100 characters
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // id, name, and animated
    @Getter private final OptionalJsonValue<EmojiObject> emoji
            = new OptionalJsonValue<>(this, "emoji", EmojiObject.class);

    // will render this option as selected by default
    @Getter private final OptionalJsonValue<Boolean> selectedByDefault
        = new OptionalJsonValue<>(this, "default", Boolean.class);

    public SelectOptionObject(JsonElement dataIn) {
        super(dataIn);
    }

    public SelectOptionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
