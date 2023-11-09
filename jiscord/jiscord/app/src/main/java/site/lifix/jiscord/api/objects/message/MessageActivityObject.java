package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class MessageActivityObject extends BaseObject {
    // The type of activity request
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // The session ID associated with this activity (send-only)
    @Getter private final OptionalJsonValue<String> sessionId
            = new OptionalJsonValue<>(this, "session_id", String.class);

    // The activity's party ID
    @Getter private final OptionalJsonValue<String> partyId
            = new OptionalJsonValue<>(this, "party_id", String.class);

    public MessageActivityObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageActivityObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
