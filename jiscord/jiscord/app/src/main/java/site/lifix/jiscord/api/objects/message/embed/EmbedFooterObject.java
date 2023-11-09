package site.lifix.jiscord.api.objects.message.embed;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class EmbedFooterObject extends BaseObject {
    // The footer text (max 2048)
    @Getter private final OptionalJsonValue<String> text
            = new OptionalJsonValue<>(this, "text", String.class);

    // Source URL of the footer icon (only supports http(s) and attachments)
    @Getter private final OptionalJsonValue<String> iconUrl
            = new OptionalJsonValue<>(this, "icon_url", String.class);

    // A proxied URL of the footer icon
    @Getter private final OptionalJsonValue<String> proxyIconUrl
            = new OptionalJsonValue<>(this, "proxy_icon_url", String.class);

    public EmbedFooterObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedFooterObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
