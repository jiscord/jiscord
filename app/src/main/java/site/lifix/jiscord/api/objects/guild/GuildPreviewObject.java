package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.api.objects.sticker.StickerObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class GuildPreviewObject extends BaseObject {
    // Approximate number of total members in the guild
    @Getter private final OptionalJsonValue<Integer> approximateMemberCount
            = new OptionalJsonValue<>(this, "approximate_member_count", Integer.class);

    // Approximate number of non-offline members in the guild
    @Getter private final OptionalJsonValue<Integer> approximatePresenceCount
            = new OptionalJsonValue<>(this, "approximate_presence_count", Integer.class);

    // The description for the guild
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The guild's discovery splash hash
    @Getter private final OptionalJsonValue<String> discoverySplash
            = new OptionalJsonValue<>(this, "discovery_splash", String.class);

    // Custom guild emojis
    private final OptionalJsonValue<JsonArray> emojis
            = new OptionalJsonValue<>(this, "emojis", JsonArray.class);

    // Enabled guild features
    private final OptionalJsonValue<JsonArray> features
            = new OptionalJsonValue<>(this, "features", JsonArray.class);

    // The guild's home header hash, also used in server guide
    @Getter private final OptionalJsonValue<String> homeHeader
            = new OptionalJsonValue<>(this, "home_header", String.class);

    // The guild's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // The ID of the guild
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the guild (2-100 characters, excluding trailing and leading whitespace)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The guild's splash hash
    @Getter private final OptionalJsonValue<String> splash
            = new OptionalJsonValue<>(this, "splash", String.class);

    // Custom guild stickers
    private final OptionalJsonValue<JsonArray> stickers
            = new OptionalJsonValue<>(this, "stickers", JsonArray.class);

    public List<EmojiObject> getEmojis() {
        return Utility.mappedJsonArray(this.emojis, EmojiObject::new);
    }

    public List<String> getFeatures() {
        return Utility.mappedJsonArray(this.features, JsonElement::getAsString);
    }

    public List<StickerObject> getStickers() {
        return Utility.mappedJsonArray(this.stickers, StickerObject::new);
    }

    public GuildPreviewObject(JsonElement data) {
        super(data);
    }

    public GuildPreviewObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
