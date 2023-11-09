package site.lifix.jiscord.api.objects.gateway;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GatewayApplicationObject extends BaseObject {
    // The ID of the application
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The application's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    public GatewayApplicationObject(JsonElement dataIn) {
        super(dataIn);
    }

    public GatewayApplicationObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
