package site.lifix.jiscord.api.objects.sticker;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class StickerItemObject extends BaseObject {
    // The type of format for the sticker
    @Getter private final OptionalJsonValue<Integer> formatType
            = new OptionalJsonValue<>(this, "format_type", Integer.class);

    // The ID of the sticker
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the sticker
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    public StickerItemObject(JsonElement data) {
        super(data);
    }

    public StickerItemObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
