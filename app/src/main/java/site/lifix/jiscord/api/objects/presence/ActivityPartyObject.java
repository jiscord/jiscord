package site.lifix.jiscord.api.objects.presence;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ActivityPartyObject extends BaseObject {
    // The ID of the party
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The party's current and maximum size (current_size, max_size)
    private final OptionalJsonValue<JsonArray> size
            = new OptionalJsonValue<>(this, "size", JsonArray.class);

    public ActivityPartySize getSize() {
        if (this.size.exists()) {
            List<Integer> sizes = Utility.mappedJsonArray(this.size, JsonElement::getAsInt);
            if (sizes.size() >= 2) {
                return new ActivityPartySize(sizes.get(0), sizes.get(1));
            }
        }

        return new ActivityPartySize(0, 0);
    }

    public ActivityPartyObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ActivityPartyObject(OptionalJsonValue<?> data) {
        super(data);
    }

    @Getter
    public static class ActivityPartySize {
        private final int currentSize;
        private final int maxSize;

        public ActivityPartySize(int currentSize, int maxSize) {
            this.currentSize = currentSize;
            this.maxSize = maxSize;
        }
    }
}
