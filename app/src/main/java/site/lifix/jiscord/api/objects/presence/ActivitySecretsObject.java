package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ActivitySecretsObject extends BaseObject {
    // The secret for joining a party
    @Getter private final OptionalJsonValue<String> join
            = new OptionalJsonValue<>(this, "join", String.class);

    // The secret for spectating a game
    @Getter private final OptionalJsonValue<String> spectate
            = new OptionalJsonValue<>(this, "spectate", String.class);

    // The secret for a specific instanced match
    @Getter private final OptionalJsonValue<String> match
            = new OptionalJsonValue<>(this, "match", String.class);

    public ActivitySecretsObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivitySecretsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
