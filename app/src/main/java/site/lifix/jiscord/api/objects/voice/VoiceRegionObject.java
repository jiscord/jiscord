package site.lifix.jiscord.api.objects.voice;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class VoiceRegionObject extends BaseObject {
    // The unique ID for the region
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the region
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Whether this is the closest to the current user's client
    @Getter private final OptionalJsonValue<Boolean> optimal
            = new OptionalJsonValue<>(this, "optimal", Boolean.class);

    // Whether this is a deprecated voice region (avoid switching to these)
    @Getter private final OptionalJsonValue<Boolean> deprecated
            = new OptionalJsonValue<>(this, "deprecated", Boolean.class);

    // Whether this is a custom voice region (used for events, etc.)
    @Getter private final OptionalJsonValue<Boolean> custom
            = new OptionalJsonValue<>(this, "custom", Boolean.class);

    public VoiceRegionObject(JsonElement dataIn) {
        super(dataIn);
    }

    public VoiceRegionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
