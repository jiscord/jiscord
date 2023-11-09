package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class PermissionOverwriteObject extends BaseObject {
    // The bitwise value of all allowed permissions
    @Getter private final OptionalJsonValue<String> allow
            = new OptionalJsonValue<>(this, "allow", String.class);

    // The bitwise value of all disallowed permissions
    @Getter private final OptionalJsonValue<String> deny
            = new OptionalJsonValue<>(this, "deny", String.class);

    // Role or user ID
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The type of overwritten entity
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    public PermissionOverwriteObject(JsonElement data) {
        super(data);
    }

    public PermissionOverwriteObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
