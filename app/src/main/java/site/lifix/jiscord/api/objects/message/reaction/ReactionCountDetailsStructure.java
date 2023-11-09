package site.lifix.jiscord.api.objects.message.reaction;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ReactionCountDetailsStructure extends BaseObject {
    // Amount of times this emoji has been used to react normally
    @Getter private final OptionalJsonValue<Integer> normal
            = new OptionalJsonValue<>(this, "normal", Integer.class);

    // Amount of times this emoji has been used to burst-react
    @Getter private final OptionalJsonValue<Integer> burst
            = new OptionalJsonValue<>(this, "burst", Integer.class);

    public ReactionCountDetailsStructure(JsonElement dataIn) {
        super(dataIn);
    }

    public ReactionCountDetailsStructure(OptionalJsonValue<?> data) {
        super(data);
    }
}
