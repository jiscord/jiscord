package site.lifix.jiscord.api.objects.application;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ApplicationSKUObject extends BaseObject {
    // The distributor of the game
    @Getter private final OptionalJsonValue<String> distributor
            = new OptionalJsonValue<>(this, "distributor", String.class);

    // The ID of the game
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The SKU of the game
    @Getter private final OptionalJsonValue<String> sku
            = new OptionalJsonValue<>(this, "sku", String.class);

    public ApplicationSKUObject(JsonElement data) {
        super(data);
    }

    public ApplicationSKUObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
