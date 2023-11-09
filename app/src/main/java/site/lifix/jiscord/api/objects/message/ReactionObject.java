package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.api.objects.message.reaction.ReactionCountDetailsStructure;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ReactionObject extends BaseObject {
    // Total amount of times this emoji has been used to react
    @Getter private final OptionalJsonValue<Integer> count
            = new OptionalJsonValue<>(this, "count", Integer.class);

    // Details about the number of times this emoji has been used to react
    @Getter private final OptionalJsonValue<ReactionCountDetailsStructure> countDetails
            = new OptionalJsonValue<>(this, "count_details", ReactionCountDetailsStructure.class);

    // Whether the current user reacted using this emoji
    @Getter private final OptionalJsonValue<Boolean> me
            = new OptionalJsonValue<>(this, "me", Boolean.class);

    // Whether the current user burst-reacted using this emoji
    @Getter private final OptionalJsonValue<Boolean> meBurst
            = new OptionalJsonValue<>(this, "me_burst", Boolean.class);

    // Reaction emoji information
    @Getter private final OptionalJsonValue<EmojiObject> emoji
            = new OptionalJsonValue<>(this, "emoji", EmojiObject.class);

    // The hex-encoded colors to render the burst reaction with
    private final OptionalJsonValue<JsonArray> burstColors
            = new OptionalJsonValue<>(this, "burst_colors", JsonArray.class);

    public List<String> getBurstColors() {
        return Utility.mappedJsonArray(this.burstColors, JsonElement::getAsString);
    }

    public ReactionObject(JsonElement dataIn) {
        super(dataIn);
    }

    public ReactionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
