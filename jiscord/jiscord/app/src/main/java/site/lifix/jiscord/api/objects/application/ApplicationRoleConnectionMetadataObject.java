package site.lifix.jiscord.api.objects.application;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ApplicationRoleConnectionMetadataObject extends BaseObject {
    // The description of the metadata field (1-200 characters)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // Translations of the description with keys in available locales
    @Getter private final OptionalJsonValue<JsonObject> descriptionLocalizations
            = new OptionalJsonValue<>(this, "description_localizations", JsonObject.class);

    // Key for the metadata field (1-50 characters, must be a-z, 0-9, or _)
    @Getter private final OptionalJsonValue<String> key
            = new OptionalJsonValue<>(this, "key", String.class);

    // The name of the metadata field (1-100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Translations of the name with keys in available locales
    @Getter private final OptionalJsonValue<JsonObject> nameLocalizations
            = new OptionalJsonValue<>(this, "name_localizations", JsonObject.class);

    // The type of metadata value
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    public ApplicationRoleConnectionMetadataObject(JsonElement data) {
        super(data);
    }

    public ApplicationRoleConnectionMetadataObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
