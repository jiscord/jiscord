package site.lifix.jiscord.api.objects.message.embed;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class EmbedAuthorObject extends BaseObject {
    // The name of the author (max 256)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // URL of the author (only supports http(s))
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // Source URL of the author's icon (only supports http(s) and attachments)
    @Getter private final OptionalJsonValue<String> iconUrl
            = new OptionalJsonValue<>(this, "icon_url", String.class);

    // A proxied URL of the author's icon
    @Getter private final OptionalJsonValue<String> proxyIconUrl
            = new OptionalJsonValue<>(this, "proxy_icon_url", String.class);

    public EmbedAuthorObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedAuthorObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
