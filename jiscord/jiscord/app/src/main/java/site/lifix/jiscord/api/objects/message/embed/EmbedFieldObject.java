package site.lifix.jiscord.api.objects.message.embed;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class EmbedFieldObject extends BaseObject {
    // The name of the field (max 256)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The value of the field (max 1024)
    @Getter private final OptionalJsonValue<String> value
            = new OptionalJsonValue<>(this, "value", String.class);

    // whether this field should display inline
    @Getter private final OptionalJsonValue<Boolean> inline
            = new OptionalJsonValue<>(this, "inline", Boolean.class);

    public EmbedFieldObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedFieldObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
