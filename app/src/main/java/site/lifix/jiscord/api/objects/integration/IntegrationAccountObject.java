package site.lifix.jiscord.api.objects.integration;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class IntegrationAccountObject extends BaseObject {
    // The ID of the account
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the account
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    public IntegrationAccountObject(JsonElement data) {
        super(data);
    }

    public IntegrationAccountObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
