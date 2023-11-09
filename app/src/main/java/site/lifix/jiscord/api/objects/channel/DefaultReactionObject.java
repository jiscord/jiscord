package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class DefaultReactionObject extends BaseObject {
    // The ID of a guild's custom emoji
    @Getter private final OptionalJsonValue<String> emojiId
            = new OptionalJsonValue<>(this, "emoji_id", String.class);

    // The unicode character of the emoji
    @Getter private final OptionalJsonValue<String> emojiName
            = new OptionalJsonValue<>(this, "emoji_name", String.class);

    public DefaultReactionObject(JsonElement data) {
        super(data);
    }

    public DefaultReactionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}

