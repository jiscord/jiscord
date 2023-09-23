package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class MessageCallObject extends BaseObject {
    // The channel recipients that participated in the call
    private final OptionalJsonValue<JsonArray> participants
            = new OptionalJsonValue<>(this, "participants", JsonArray.class);

    // When the call ended, if it has
    @Getter private final OptionalJsonValue<String> endedTimestamp
            = new OptionalJsonValue<>(this, "ended_timestamp", String.class);

    public List<String> getParticipants() {
        return Utility.mappedJsonArray(this.participants, JsonElement::getAsString);
    }

    public MessageCallObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageCallObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
