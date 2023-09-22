package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ClientStatusObject extends BaseObject {
    // The user's status on an active desktop (Windows, Linux, Mac) application session
    @Getter private final OptionalJsonValue<String> desktop
            = new OptionalJsonValue<>(this, "desktop", String.class);

    // The user's status on an active mobile (iOS, Android) application session
    @Getter private final OptionalJsonValue<String> mobile
            = new OptionalJsonValue<>(this, "mobile", String.class);

    // The user's status on an active web (browser) application session
    @Getter private final OptionalJsonValue<String> web
            = new OptionalJsonValue<>(this, "web", String.class);

    // The user's status on an active embedded (Xbox, PlayStation) session
    @Getter private final OptionalJsonValue<String> embedded
            = new OptionalJsonValue<>(this, "embedded", String.class);

    public ClientStatusObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ClientStatusObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
