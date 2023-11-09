package site.lifix.jiscord.api.objects.interactions;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class MessageInteractionObject extends BaseObject {
    // id of the interaction
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // the type of interaction
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // the name of the application command
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // the user who invoked the interaction
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    public MessageInteractionObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageInteractionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
