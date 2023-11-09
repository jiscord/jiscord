package site.lifix.jiscord.api.objects.guild.permissions;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class RoleObject extends BaseObject {
    // Integer representation of a hexadecimal color code for the role
    @Getter private final OptionalJsonValue<Integer> color
            = new OptionalJsonValue<>(this, "color", Integer.class);

    // The description for the role (max 90 characters)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The role's flags
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // Whether this role is pinned in the user listing
    @Getter private final OptionalJsonValue<Boolean> hoist
            = new OptionalJsonValue<>(this, "hoist", Boolean.class);

    // The role's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // The ID of the role
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // Whether this role is managed by an integration
    @Getter private final OptionalJsonValue<Boolean> managed
            = new OptionalJsonValue<>(this, "managed", Boolean.class);

    // Whether this role is mentionable
    @Getter private final OptionalJsonValue<Boolean> mentionable
            = new OptionalJsonValue<>(this, "mentionable", Boolean.class);

    // The name of the role (max 100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The permission bitwise value for the role
    @Getter private final OptionalJsonValue<String> permissions
            = new OptionalJsonValue<>(this, "permissions", String.class);

    // Position of this role
    @Getter private final OptionalJsonValue<Integer> position
            = new OptionalJsonValue<>(this, "position", Integer.class);

    // The tags this role has
    @Getter private final OptionalJsonValue<RoleTagsObject> tags
            = new OptionalJsonValue<>(this, "tags", RoleTagsObject.class);

    // The role's unicode emoji
    @Getter private final OptionalJsonValue<String> unicodeEmoji
            = new OptionalJsonValue<>(this, "unicode_emoji", String.class);

    public RoleObject(JsonElement data) {
        super(data);
    }

    public RoleObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
