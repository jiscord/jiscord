package site.lifix.jiscord.api.objects.gateway;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class TutorialObject extends BaseObject {
    // Whether the user has suppressed all tutorial indicators
    @Getter private final OptionalJsonValue<Boolean> indicatorsSuppressed
            = new OptionalJsonValue<>(this, "indicators_suppressed", Boolean.class);

    // An array of the tutorial indicators the user has confirmed
    private final OptionalJsonValue<JsonArray> indicatorsConfirmed
            = new OptionalJsonValue<>(this, "indicators_confirmed", JsonArray.class);

    public List<String> getIndicatorsConfirmed() {
        return Utility.mappedJsonArray(this.indicatorsConfirmed, JsonElement::getAsString);
    }

    public TutorialObject(JsonElement dataIn) {
        super(dataIn);
    }

    public TutorialObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
