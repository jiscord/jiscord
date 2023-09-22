package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ForumTagObject extends BaseObject {
    // The ID of a guild's custom emoji
    @Getter private final OptionalJsonValue<String> emojiId
            = new OptionalJsonValue<>(this, "emoji_id", String.class);

    // The unicode character of the emoji
    @Getter private final OptionalJsonValue<String> emojiName
            = new OptionalJsonValue<>(this, "emoji_name", String.class);

    // The ID of the tag
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // Whether this tag can only be added to or removed from threads by members with the MANAGE_THREADS permission
    @Getter private final OptionalJsonValue<Boolean> moderated
            = new OptionalJsonValue<>(this, "moderated", Boolean.class);

    // The name of the tag (max 20 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    public ForumTagObject(JsonElement data) {
        super(data);
    }

    public ForumTagObject(OptionalJsonValue<?> data) {
        super(data);
    }
}

