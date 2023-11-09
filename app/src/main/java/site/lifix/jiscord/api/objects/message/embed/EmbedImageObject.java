package site.lifix.jiscord.api.objects.message.embed;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class EmbedImageObject extends BaseObject {
    // Source URL of image (only supports http(s) and attachments)
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // A proxied URL of the image
    @Getter private final OptionalJsonValue<String> proxyUrl
            = new OptionalJsonValue<>(this, "proxy_url", String.class);

    // Height of image
    @Getter private final OptionalJsonValue<Integer> height
            = new OptionalJsonValue<>(this, "height", Integer.class);

    // Width of image
    @Getter private final OptionalJsonValue<Integer> width
            = new OptionalJsonValue<>(this, "width", Integer.class);

    public EmbedImageObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedImageObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
