package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class UserSettingsObject extends BaseObject {
    @Getter private final OptionalJsonValue<Integer> afkTimeout
            = new OptionalJsonValue<>(this, "afk_timeout", Integer.class);
    @Getter private final OptionalJsonValue<Integer> allowAccessibilityDetection
            = new OptionalJsonValue<>(this, "allow_accessibility_detection", Integer.class);
    @Getter private final OptionalJsonValue<Boolean> animateEmoji
            = new OptionalJsonValue<>(this, "animate_emoji", Boolean.class);
    @Getter private final OptionalJsonValue<Integer> animateStickers
            = new OptionalJsonValue<>(this, "animate_stickers", Integer.class);
    @Getter private final OptionalJsonValue<Boolean> broadcastAllowFriends
            = new OptionalJsonValue<>(this, "broadcast_allow_friends", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> convertEmoticons
            = new OptionalJsonValue<>(this, "convert_emoticons", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> contactSyncEnabled
            = new OptionalJsonValue<>(this, "contact_sync_enabled", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> defaultGuildsRestricted
            = new OptionalJsonValue<>(this, "default_guilds_restricted", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> detectPlatformAccounts
            = new OptionalJsonValue<>(this, "detect_platform_accounts", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> developerMode
            = new OptionalJsonValue<>(this, "developer_mode", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> disableGamesTab
            = new OptionalJsonValue<>(this, "disable_games_tab", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> enableTtsCommand
            = new OptionalJsonValue<>(this, "enable_tts_command", Boolean.class);
    @Getter private final OptionalJsonValue<Integer> explicitContentFilter
            = new OptionalJsonValue<>(this, "explicit_content_filter", Integer.class);
    @Getter private final OptionalJsonValue<Integer> friendDiscoveryFlags
            = new OptionalJsonValue<>(this, "friend_discovery_flags", Integer.class);
    @Getter private final OptionalJsonValue<Boolean> gifAutoPlay
            = new OptionalJsonValue<>(this, "gif_auto_play", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> inlineAttachmentMedia
            = new OptionalJsonValue<>(this, "inline_attachment_media", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> inlineEmbedMedia
            = new OptionalJsonValue<>(this, "inline_embed_media", Boolean.class);
    @Getter private final OptionalJsonValue<String> locale
            = new OptionalJsonValue<>(this, "locale", String.class);
    @Getter private final OptionalJsonValue<Boolean> messageDisplayCompact
            = new OptionalJsonValue<>(this, "message_display_compact", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> nativePhoneIntegrationEnabled
            = new OptionalJsonValue<>(this, "native_phone_integration_enabled", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> passwordless
            = new OptionalJsonValue<>(this, "passwordless", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> renderEmbeds
            = new OptionalJsonValue<>(this, "render_embeds", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> renderReactions
            = new OptionalJsonValue<>(this, "render_reactions", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> showCurrentGame
            = new OptionalJsonValue<>(this, "show_current_game", Boolean.class);
    @Getter private final OptionalJsonValue<String> status
            = new OptionalJsonValue<>(this, "status", String.class);
    @Getter private final OptionalJsonValue<Boolean> streamNotificationsEnabled
            = new OptionalJsonValue<>(this, "stream_notifications_enabled", Boolean.class);
    @Getter private final OptionalJsonValue<String> theme
            = new OptionalJsonValue<>(this, "theme", String.class);
    @Getter private final OptionalJsonValue<Integer> timezoneOffset
            = new OptionalJsonValue<>(this, "timezone_offset", Integer.class);
    @Getter private final OptionalJsonValue<Boolean> viewNsfwCommands
            = new OptionalJsonValue<>(this, "view_nsfw_commands", Boolean.class);
    @Getter private final OptionalJsonValue<Boolean> viewNsfwGuilds
            = new OptionalJsonValue<>(this, "view_nsfw_guilds", Boolean.class);

    public UserSettingsObject(JsonElement data) {
        super(data);
    }

    public UserSettingsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
