package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class UserObject extends BaseObject {
    // The ID of the user
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The user's username, may be unique across the platform (2-32 characters)
    @Getter private final OptionalJsonValue<String> username
            = new OptionalJsonValue<>(this, "username", String.class);

    // The user's stringified 4-digit Discord tag
    @Getter private final OptionalJsonValue<String> discriminator
            = new OptionalJsonValue<>(this, "discriminator", String.class);

    // The user's display name (1-32 characters); for bots, this is the application name
    @Getter private final OptionalJsonValue<String> globalName
            = new OptionalJsonValue<>(this, "global_name", String.class);

    // The user's avatar hash
    @Getter private final OptionalJsonValue<String> avatar
            = new OptionalJsonValue<>(this, "avatar", String.class);

    // The user's avatar decoration hash
    @Getter private final OptionalJsonValue<String> avatarDecoration
            = new OptionalJsonValue<>(this, "avatar_decoration", String.class);

    // Whether the user belongs to an OAuth2 application
    @Getter private final OptionalJsonValue<Boolean> bot
            = new OptionalJsonValue<>(this, "bot", Boolean.class);

    // Whether the user is an official Discord System user (part of the urgent message system)
    @Getter private final OptionalJsonValue<Boolean> system
            = new OptionalJsonValue<>(this, "system", Boolean.class);

    // Whether the user has two-factor authentication enabled on their account
    @Getter private final OptionalJsonValue<Boolean> mfaEnabled
            = new OptionalJsonValue<>(this, "mfa_enabled", Boolean.class);

    // Whether the user is allowed to see NSFW content, null if not yet known
    @Getter private final OptionalJsonValue<Boolean> nsfwAllowed
            = new OptionalJsonValue<>(this, "nsfw_allowed", Boolean.class);

    // The user's pronouns (max 40 characters)
    @Getter private final OptionalJsonValue<String> pronouns
            = new OptionalJsonValue<>(this, "pronouns", String.class);

    // The user's bio (max 190 characters)
    @Getter private final OptionalJsonValue<String> bio
            = new OptionalJsonValue<>(this, "bio", String.class);

    // The user's banner hash
    @Getter private final OptionalJsonValue<String> banner
            = new OptionalJsonValue<>(this, "banner", String.class);

    // The user's banner color encoded as an integer representation of hexadecimal color code
    @Getter private final OptionalJsonValue<String> bannerColor
            = new OptionalJsonValue<>(this, "banner_color", String.class);

    // The user's chosen language option
    @Getter private final OptionalJsonValue<String> locale
            = new OptionalJsonValue<>(this, "locale", String.class);

    // Whether the email on this account has been verified
    @Getter private final OptionalJsonValue<Boolean> verified
            = new OptionalJsonValue<>(this, "verified", Boolean.class);

    // The user's email
    @Getter private final OptionalJsonValue<String> email
            = new OptionalJsonValue<>(this, "email", String.class);

    // The user's E.164-formatted phone number
    @Getter private final OptionalJsonValue<String> phone
            = new OptionalJsonValue<>(this, "phone", String.class);

    // The type of premium (Nitro) subscription on a user's account
    @Getter private final OptionalJsonValue<Integer> premiumType
            = new OptionalJsonValue<>(this, "premium_type", Integer.class);

    // The ID of the user's personal, non-employee user account
    @Getter private final OptionalJsonValue<String> personalConnectionId
            = new OptionalJsonValue<>(this, "personal_connection_id", String.class);

    // The flags on a user's account
    @Getter private final OptionalJsonValue<Integer> flags
            = new OptionalJsonValue<>(this, "flags", Integer.class);

    // The public flags on a user's account
    @Getter private final OptionalJsonValue<Integer> publicFlags
            = new OptionalJsonValue<>(this, "public_flags", Integer.class);

    // The purchased flags on a user's account
    @Getter private final OptionalJsonValue<Integer> purchasedFlags
            = new OptionalJsonValue<>(this, "purchased_flags", Integer.class);

    // The premium usage flags on a user's account
    @Getter private final OptionalJsonValue<Integer> premiumUsageFlags
            = new OptionalJsonValue<>(this, "premium_usage_flags", Integer.class);

    // Whether the user has used the desktop client before
    @Getter private final OptionalJsonValue<Boolean> desktop
            = new OptionalJsonValue<>(this, "desktop", Boolean.class);

    // Whether the user has used the mobile client before
    @Getter private final OptionalJsonValue<Boolean> mobile
            = new OptionalJsonValue<>(this, "mobile", Boolean.class);

    // Whether the user's email has failed to deliver and is no longer valid
    @Getter private final OptionalJsonValue<Boolean> hasBouncedEmail
            = new OptionalJsonValue<>(this, "has_bounced_email", Boolean.class);

    public UserObject(JsonElement data) {
        super(data);
    }

    public UserObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
