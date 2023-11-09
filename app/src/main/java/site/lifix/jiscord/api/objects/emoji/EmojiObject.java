package site.lifix.jiscord.api.objects.emoji;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class EmojiObject extends BaseObject {
    // Whether this emoji is animated
    @Getter private final OptionalJsonValue<Boolean> animated
            = new OptionalJsonValue<>(this, "animated", Boolean.class);

    // Whether this emoji can be used, may be false due to loss of premium subscriptions (boosts)
    @Getter private final OptionalJsonValue<Boolean> available
            = new OptionalJsonValue<>(this, "available", Boolean.class);

    // The ID of the emoji
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // Whether this emoji is managed
    @Getter private final OptionalJsonValue<Boolean> managed
            = new OptionalJsonValue<>(this, "managed", Boolean.class);

    // The name of the emoji
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Whether this emoji must be wrapped in colons
    @Getter private final OptionalJsonValue<Boolean> requireColons
            = new OptionalJsonValue<>(this, "require_colons", Boolean.class);

    // The roles allowed to use the emoji
    private final OptionalJsonValue<JsonArray> roles
            = new OptionalJsonValue<>(this, "roles", JsonArray.class);

    // The user that uploaded the emoji
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    public List<String> getRoles() {
        return Utility.mappedJsonArray(this.roles, JsonElement::getAsString);
    }

    public EmojiObject(JsonElement data) {
        super(data);
    }

    public EmojiObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
