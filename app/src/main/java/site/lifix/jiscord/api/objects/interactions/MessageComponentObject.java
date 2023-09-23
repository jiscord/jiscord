package site.lifix.jiscord.api.objects.interactions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class MessageComponentObject extends BaseObject {
    // component type       all types
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // a developer-defined identifier for the component, max 100 characters Buttons, Select Menus
    @Getter private final OptionalJsonValue<String> customId
            = new OptionalJsonValue<>(this, "custom_id", String.class);

    // whether the component is disabled, default false     Buttons, Select Menus
    @Getter private final OptionalJsonValue<Boolean> disabled
            = new OptionalJsonValue<>(this, "disabled", Boolean.class);

    // one of button styles Buttons
    @Getter private final OptionalJsonValue<Integer> style
            = new OptionalJsonValue<>(this, "style", Integer.class);

    // text that appears on the button, max 80 characters   Buttons
    @Getter private final OptionalJsonValue<String> label
            = new OptionalJsonValue<>(this, "label", String.class);

    // name, id, and animated       Buttons
    @Getter private final OptionalJsonValue<EmojiObject> emoji
            = new OptionalJsonValue<>(this, "emoji", EmojiObject.class);

    // a url for link-style buttons Buttons
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // the choices in the select, max 25    Select Menus
    private final OptionalJsonValue<JsonArray> options
            = new OptionalJsonValue<>(this, "options", JsonArray.class);

    // custom placeholder text if nothing is selected, max 100 characters   Select Menus
    @Getter private final OptionalJsonValue<String> placeholder
            = new OptionalJsonValue<>(this, "placeholder", String.class);

    // the minimum number of items that must be chosen; default 1, min 0, max 25    Select Menus
    @Getter private final OptionalJsonValue<Integer> minValues
            = new OptionalJsonValue<>(this, "min_values", Integer.class);

    // the maximum number of items that can be chosen; default 1, max 25    Select Menus
    @Getter private final OptionalJsonValue<Integer> maxValues
            = new OptionalJsonValue<>(this, "max_values", Integer.class);

    // a list of child components   Action Rows
    private final OptionalJsonValue<JsonArray> components
            = new OptionalJsonValue<>(this, "components", JsonArray.class);

    public List<SelectOptionObject> getOptions() {
        return Utility.mappedJsonArray(this.options, SelectOptionObject::new);
    }

    public List<MessageComponentObject> getComponents() {
        return Utility.mappedJsonArray(this.components, MessageComponentObject::new);
    }

    public MessageComponentObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageComponentObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
