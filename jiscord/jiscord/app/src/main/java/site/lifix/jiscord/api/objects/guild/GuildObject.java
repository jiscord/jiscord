package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.emoji.EmojiObject;
import site.lifix.jiscord.api.objects.guild.permissions.RoleObject;
import site.lifix.jiscord.api.objects.sticker.StickerObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class GuildObject extends BaseObject {
    // The ID of the guild's AFK channel; this is where members in voice idle for longer than afk_timeout are moved
    @Getter private final OptionalJsonValue<String> afkChannelId
            = new OptionalJsonValue<>(this, "afk_channel_id", String.class);

    // The AFK timeout of the guild (one of 60, 300, 900, 1800, 3600, in seconds)
    @Getter private final OptionalJsonValue<Integer> afkTimeout
            = new OptionalJsonValue<>(this, "afk_timeout", Integer.class);

    // The application ID of the guild's owner, if bot-created
    @Getter private final OptionalJsonValue<String> applicationId
            = new OptionalJsonValue<>(this, "application_id", String.class);

    // Approximate count of total members in the guild
    @Getter private final OptionalJsonValue<Integer> approximateMemberCount
            = new OptionalJsonValue<>(this, "approximate_member_count", Integer.class);

    // Approximate count of non-offline members in the guild
    @Getter private final OptionalJsonValue<Integer> approximatePresenceCount
            = new OptionalJsonValue<>(this, "approximate_presence_count", Integer.class);

    // The guild's banner hash
    @Getter private final OptionalJsonValue<String> banner
            = new OptionalJsonValue<>(this, "banner", String.class);

    // The description for the guild
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The guild's discovery splash hash
    @Getter private final OptionalJsonValue<String> discoverySplash
            = new OptionalJsonValue<>(this, "discovery_splash", String.class);

    // Custom guild emojis
    private final OptionalJsonValue<JsonArray> emojis
            = new OptionalJsonValue<>(this, "emojis", JsonArray.class);

    // Whose messages are scanned and deleted for explicit content in the guild
    @Getter private final OptionalJsonValue<Integer> explicitContentFilter
            = new OptionalJsonValue<>(this, "explicit_content_filter", Integer.class);

    // Enabled guild features
    private final OptionalJsonValue<JsonArray> features
            = new OptionalJsonValue<>(this, "features", JsonArray.class);

    // The guild's home header hash, also used in server guide
    @Getter private final OptionalJsonValue<String> homeHeader
            = new OptionalJsonValue<>(this, "home_header", String.class);

    // The type of student hub the guild is, if it is a student hub
    @Getter private final OptionalJsonValue<Integer> hubType
            = new OptionalJsonValue<>(this, "hub_type", Integer.class);

    // The guild's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // The ID of the guild
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The ID of the guild's latest onboarding prompt option
    @Getter private final OptionalJsonValue<String> latestOnboardingQuestionId
            = new OptionalJsonValue<>(this, "latest_onboarding_question_id", String.class);

    // The maximum number of members for the guild
    @Getter private final OptionalJsonValue<Integer> maxMembers
            = new OptionalJsonValue<>(this, "max_members", Integer.class);

    // The maximum amount of users that can watch a video stream in a stage channel at once
    @Getter private final OptionalJsonValue<Integer> maxStageVideoChannelUsers
            = new OptionalJsonValue<>(this, "max_stage_video_channel_users", Integer.class);

    // The maximum amount of users that can watch a video stream in a voice channel at once
    @Getter private final OptionalJsonValue<Integer> maxVideoChannelUsers
            = new OptionalJsonValue<>(this, "max_video_channel_users", Integer.class);

    // Required MFA level for administrative actions within the guild
    @Getter private final OptionalJsonValue<Integer> mfaLevel
            = new OptionalJsonValue<>(this, "mfa_level", Integer.class);

    // The name of the guild (2-100 characters, excluding trailing and leading whitespace)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Whether the guild is considered NSFW (EXPLICIT or AGE_RESTRICTED)
    @Getter private final OptionalJsonValue<Boolean> nsfw
            = new OptionalJsonValue<>(this, "nsfw", Boolean.class);

    // The NSFW level of the guild
    @Getter private final OptionalJsonValue<Integer> nsfwLevel
            = new OptionalJsonValue<>(this, "nsfw_level", Integer.class);

    // The user ID of the guild's owner
    @Getter private final OptionalJsonValue<String> ownerId
            = new OptionalJsonValue<>(this, "owner_id", String.class);

    // The preferred locale of the guild; used in discovery and notices from Discord (default "en-US")
    @Getter private final OptionalJsonValue<String> preferredLocale
            = new OptionalJsonValue<>(this, "preferred_locale", String.class);

    // Whether the guild has the premium (boost) progress bar enabled
    @Getter private final OptionalJsonValue<Boolean> premiumProgressBarEnabled
            = new OptionalJsonValue<>(this, "premium_progress_bar_enabled", Boolean.class);

    // The number of premium subscriptions (boosts) the guild currently has
    @Getter private final OptionalJsonValue<Integer> premiumSubscriptionCount
            = new OptionalJsonValue<>(this, "premium_subscription_count", Integer.class);

    // The guild's premium tier (boost level)
    @Getter private final OptionalJsonValue<Integer> premiumTier
            = new OptionalJsonValue<>(this, "premium_tier", Integer.class);

    // The ID of the channel where admins and moderators of community guilds receive notices from Discord
    @Getter private final OptionalJsonValue<String> publicUpdatesChannelId
            = new OptionalJsonValue<>(this, "public_updates_channel_id", String.class);

    // The main voice region ID of the guild
    @Getter private final OptionalJsonValue<String> region
            = new OptionalJsonValue<>(this, "region", String.class);

    // Roles in the guild
    private final OptionalJsonValue<JsonArray> roles
            = new OptionalJsonValue<>(this, "roles", JsonArray.class);

    // The ID of the channel where community guilds display rules and/or guidelines
    @Getter private final OptionalJsonValue<String> rulesChannelId
            = new OptionalJsonValue<>(this, "rules_channel_id", String.class);

    // The ID of the channel where admins and moderators of community guilds receive safety alerts from Discord
    @Getter private final OptionalJsonValue<String> safetyAlertsChannelId
            = new OptionalJsonValue<>(this, "safety_alerts_channel_id", String.class);

    // The guild's splash hash
    @Getter private final OptionalJsonValue<String> splash
            = new OptionalJsonValue<>(this, "splash", String.class);

    // Custom guild stickers
    private final OptionalJsonValue<JsonArray> stickers
            = new OptionalJsonValue<>(this, "stickers", JsonArray.class);

    // The ID of the channel where system event messages, such as member joins and premium subscriptions (boosts),
    //  are posted
    @Getter private final OptionalJsonValue<String> systemChannelId
            = new OptionalJsonValue<>(this, "system_channel_id", String.class);

    // The flags that limit system event messages
    @Getter private final OptionalJsonValue<Integer> systemChannelFlags
            = new OptionalJsonValue<>(this, "system_channel_flags", Integer.class);

    // The guild's vanity invite code
    @Getter private final OptionalJsonValue<String> vanityUrlCode
            = new OptionalJsonValue<>(this, "vanity_url_code", String.class);

    // The verification level required for the guild
    @Getter private final OptionalJsonValue<Integer> verificationLevel
            = new OptionalJsonValue<>(this, "verification_level", Integer.class);

    // Whether the guild widget is enabled
    @Getter private final OptionalJsonValue<Boolean> widgetEnabled
            = new OptionalJsonValue<>(this, "widget_enabled", Boolean.class);

    // The channel ID that the widget will generate an invite to, if any
    @Getter private final OptionalJsonValue<String> widgetChannelId
            = new OptionalJsonValue<>(this, "widget_channel_id", String.class);

    public List<EmojiObject> getEmojis() {
        return Utility.mappedJsonArray(this.emojis, EmojiObject::new);
    }

    public List<String> getFeatures() {
        return Utility.mappedJsonArray(this.features, JsonElement::getAsString);
    }

    public List<RoleObject> getRoles() {
        return Utility.mappedJsonArray(this.roles, RoleObject::new);
    }

    public List<StickerObject> getStickers() {
        return Utility.mappedJsonArray(this.stickers, StickerObject::new);
    }

    public GuildObject(JsonElement data) {
        super(data);
    }

    public GuildObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
