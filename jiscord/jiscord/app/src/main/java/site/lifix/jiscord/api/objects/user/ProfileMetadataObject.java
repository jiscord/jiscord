package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ProfileMetadataObject extends BaseObject {
    // The user's banner color encoded as an integer representation of hexadecimal color code
    @Getter private final OptionalJsonValue<Integer> accentColor
            = new OptionalJsonValue<>(this, "accent_color", Integer.class);

    // The user's banner hash
    @Getter private final OptionalJsonValue<String> banner
            = new OptionalJsonValue<>(this, "banner", String.class);

    // The user's bio (max 190 characters)
    @Getter private final OptionalJsonValue<String> bio
            = new OptionalJsonValue<>(this, "bio", String.class);

    // The user's profile emoji
    @Getter private final OptionalJsonValue<EmojiObject> emoji
            = new OptionalJsonValue<>(this, "emoji", EmojiObject.class);

    // The guild ID this profile applies to, if it is a guild profile
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The user's pronouns (max 40 characters)
    @Getter private final OptionalJsonValue<String> pronouns
            = new OptionalJsonValue<>(this, "pronouns", String.class);

    // The user's profile popout animation particle type
    @Getter private final OptionalJsonValue<String> popoutAnimationParticleType
            = new OptionalJsonValue<>(this, "popout_animation_particle_type", String.class);

    // The user's two theme colors encoded as an array of integers representing hexadecimal color codes
    private final OptionalJsonValue<JsonArray> themeColors
            = new OptionalJsonValue<>(this, "theme_colors", JsonArray.class);

    public List<Integer> getThemeColors() {
        return Utility.mappedJsonArray(this.themeColors, JsonElement::getAsInt);
    }

    public ProfileMetadataObject(JsonElement data) {
        super(data);
    }

    public ProfileMetadataObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
