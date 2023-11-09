package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class PresenceObject extends BaseObject {
    // The user whose presence is being updated
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    // ID of the guild the presence was updated in, if this is a guild presence
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // Unix time (in milliseconds) of when the user's presence was last modified
    @Getter private final OptionalJsonValue<Integer> lastModified
            = new OptionalJsonValue<>(this, "last_modified", Integer.class);

    // The status of the user
    @Getter private final OptionalJsonValue<String> status
            = new OptionalJsonValue<>(this, "status", String.class);

    // The current activities the user is partaking in
    private final OptionalJsonValue<JsonArray> activities
            = new OptionalJsonValue<>(this, "activities", JsonArray.class);

    // The platform-dependent status of the user
    @Getter private final OptionalJsonValue<ClientStatusObject> clientStatus
            = new OptionalJsonValue<>(this, "client_status", ClientStatusObject.class);

    public List<ActivityObject> getActivities() {
        return Utility.mappedJsonArray(this.activities, ActivityObject::new);
    }

    public PresenceObject(JsonElement dataIn) {
        super(dataIn);
    }

    public PresenceObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
