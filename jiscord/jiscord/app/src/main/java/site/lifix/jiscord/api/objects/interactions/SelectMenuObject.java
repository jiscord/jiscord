package site.lifix.jiscord.api.objects.interactions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class SelectMenuObject extends BaseObject {
    // 3 for a select menu
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // a developer-defined identifier for the button, max 100 characters
    @Getter private final OptionalJsonValue<String> customId
            = new OptionalJsonValue<>(this, "custom_id", String.class);

    // the choices in the select, max 25
    private final OptionalJsonValue<JsonArray> options
            = new OptionalJsonValue<>(this, "options", JsonArray.class);

    // custom placeholder text if nothing is selected, max 100 characters
    @Getter private final OptionalJsonValue<String> placeholder
            = new OptionalJsonValue<>(this, "placeholder", String.class);

    // the minimum number of items that must be chosen; default 1, min 0, max 25
    @Getter private final OptionalJsonValue<Integer> minValues
            = new OptionalJsonValue<>(this, "min_values", Integer.class);

    // the maximum number of items that can be chosen; default 1, max 25
    @Getter private final OptionalJsonValue<Integer> maxValues
            = new OptionalJsonValue<>(this, "max_values", Integer.class);

    // disable the select, default false
    @Getter private final OptionalJsonValue<Boolean> disabled
            = new OptionalJsonValue<>(this, "disabled", Boolean.class);

    public List<SelectOptionObject> getOptions() {
        return Utility.mappedJsonArray(this.options, SelectOptionObject::new);
    }

    public SelectMenuObject(JsonElement dataIn) {
        super(dataIn);
    }

    public SelectMenuObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
