package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class AllowedMentionsObject extends BaseObject {
    // The allowed mention types to parse from the content
    private final OptionalJsonValue<JsonArray> parse
            = new OptionalJsonValue<>(this, "parse", JsonArray.class);

    // The role IDs to mention (max 100)
    private final OptionalJsonValue<JsonArray> roles
            = new OptionalJsonValue<>(this, "roles", JsonArray.class);

    // The user IDs to mention (max 100)
    private final OptionalJsonValue<JsonArray> users
            = new OptionalJsonValue<>(this, "users", JsonArray.class);

    // For replies, whether to mention the author of the message being replied to (default false)
    @Getter private final OptionalJsonValue<Boolean> repliedUser
            = new OptionalJsonValue<>(this, "replied_user", Boolean.class);

    public List<String> getParse() {
        return Utility.mappedJsonArray(this.parse, JsonElement::getAsString);
    }

    public List<String> getRoles() {
        return Utility.mappedJsonArray(this.roles, JsonElement::getAsString);
    }

    public List<String> getUsers() {
        return Utility.mappedJsonArray(this.users, JsonElement::getAsString);
    }

    public AllowedMentionsObject(JsonElement dataIn) {
        super(dataIn);
    }

    public AllowedMentionsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
