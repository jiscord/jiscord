package site.lifix.jiscord.api.objects.sticker;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class StickerObject extends BaseObject {
    // Whether this guild sticker can be used, may be false due to loss of premium subscriptions (boosts)
    @Getter private final OptionalJsonValue<Boolean> available
            = new OptionalJsonValue<>(this, "available", Boolean.class);

    // The description for the sticker (max 100 characters)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The type of format for the sticker
    @Getter private final OptionalJsonValue<Integer> formatType
            = new OptionalJsonValue<>(this, "format_type", Integer.class);

    // The ID of the guild the sticker is attached to
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The ID of the sticker
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the sticker (2-30 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // For standard stickers, ID of the pack the sticker is from
    @Getter private final OptionalJsonValue<String> packId
            = new OptionalJsonValue<>(this, "pack_id", String.class);

    // The standard sticker's sort order within its pack
    @Getter private final OptionalJsonValue<Integer> sortValue
            = new OptionalJsonValue<>(this, "sort_value", Integer.class);

    // Autocomplete/suggestion tags for the sticker (1-200 characters)
    @Getter private final OptionalJsonValue<String> tags
            = new OptionalJsonValue<>(this, "tags", String.class);

    // The type of sticker
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    // The user that uploaded the guild sticker
    @Getter private final OptionalJsonValue<UserObject> user
            = new OptionalJsonValue<>(this, "user", UserObject.class);

    public StickerObject(JsonElement data) {
        super(data);
    }

    public StickerObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
