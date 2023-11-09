package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ActivityTimestampsObject extends BaseObject {
    // Unix time (in milliseconds) of when the activity starts
    @Getter private final OptionalJsonValue<Integer> start
            = new OptionalJsonValue<>(this, "start", Integer.class);

    // Unix time (in milliseconds) of when the activity ends
    @Getter private final OptionalJsonValue<Integer> end
            = new OptionalJsonValue<>(this, "end", Integer.class);

    public ActivityTimestampsObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivityTimestampsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
