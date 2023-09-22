package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ActivityObject extends BaseObject {
    // The activity's name
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The activity type
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // Stream URL (only validated when type is 1)
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // Unix timestamp (in milliseconds) of when the activity was added to the user's session
    @Getter private final OptionalJsonValue<Integer> createdAt
            = new OptionalJsonValue<>(this, "created_at", Integer.class);

    // Unix timestamps (in milliseconds) for start and/or end of the game
    @Getter private final OptionalJsonValue<ActivityTimestampsObject> timestamps
            = new OptionalJsonValue<>(this, "timestamps", ActivityTimestampsObject.class);

    // Application ID of the game
    @Getter private final OptionalJsonValue<String> applicationId
            = new OptionalJsonValue<>(this, "application_id", String.class);

    // What the user is currently doing
    @Getter private final OptionalJsonValue<String> details
            = new OptionalJsonValue<>(this, "details", String.class);

    // The user's current party status
    @Getter private final OptionalJsonValue<String> state
            = new OptionalJsonValue<>(this, "state", String.class);

    // The emoji used for a custom status
    @Getter private final OptionalJsonValue<ActivityEmojiObject> emoji
            = new OptionalJsonValue<>(this, "emoji", ActivityEmojiObject.class);

    // Information for the current party of the user
    @Getter private final OptionalJsonValue<ActivityPartyObject> party
            = new OptionalJsonValue<>(this, "party", ActivityPartyObject.class);

    // Images for the presence and their hover texts
    @Getter private final OptionalJsonValue<ActivityAssetsObject> assets
            = new OptionalJsonValue<>(this, "assets", ActivityAssetsObject.class);

    // Secrets for rich presence joining and spectating
    @Getter private final OptionalJsonValue<ActivitySecretsObject> secrets
            = new OptionalJsonValue<>(this, "secrets", ActivitySecretsObject.class);

    // Whether or not the activity is an instanced game session
    @Getter private final OptionalJsonValue<Boolean> instance
            = new OptionalJsonValue<>(this, "instance", Boolean.class);

    // The activity's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // Custom buttons shown in rich presence (max 2)
    private final OptionalJsonValue<JsonArray> buttons
            = new OptionalJsonValue<>(this, "buttons", JsonArray.class);

    public List<String> getButtons() {
        return Utility.mappedJsonArray(this.buttons, JsonElement::getAsString);
    }

    public ActivityObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivityObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
