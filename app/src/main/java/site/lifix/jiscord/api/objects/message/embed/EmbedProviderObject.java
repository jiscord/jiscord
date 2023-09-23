package site.lifix.jiscord.api.objects.message.embed;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class EmbedProviderObject extends BaseObject {
    // The name of the provider
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // URL of the provider
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    public EmbedProviderObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedProviderObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
