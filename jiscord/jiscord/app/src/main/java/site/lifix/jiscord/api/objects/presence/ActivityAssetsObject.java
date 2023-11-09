package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ActivityAssetsObject extends BaseObject {
    // The large activity asset image
    @Getter private final OptionalJsonValue<String> largeImage
            = new OptionalJsonValue<>(this, "large_image", String.class);

    // Text displayed when hovering over the large image of the activity
    @Getter private final OptionalJsonValue<String> largeText
            = new OptionalJsonValue<>(this, "large_text", String.class);

    // The small activity asset image
    @Getter private final OptionalJsonValue<String> smallImage
            = new OptionalJsonValue<>(this, "small_image", String.class);

    // Text displayed when hovering over the small image of the activity
    @Getter private final OptionalJsonValue<String> smallText
            = new OptionalJsonValue<>(this, "small_text", String.class);

    public ActivityAssetsObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivityAssetsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
