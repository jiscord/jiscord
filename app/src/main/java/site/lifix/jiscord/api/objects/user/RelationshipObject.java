package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class RelationshipObject extends BaseObject {
    // The ID of the target user
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The nickname of the user in this relationship (1-32 characters)
    @Getter private final OptionalJsonValue<String> nickname
            = new OptionalJsonValue<>(this, "nickname", String.class);

    // When the user requested a relationship
    @Getter private final OptionalJsonValue<String> since
            = new OptionalJsonValue<>(this, "since", String.class);

    // The type of relationship
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // The target user
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    public RelationshipObject(JsonElement data) {
        super(data);
    }

    public RelationshipObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
