package site.lifix.jiscord.api.statics.cdn;

import site.lifix.jiscord.api.objects.guild.GuildObject;
import site.lifix.jiscord.api.objects.user.UserObject;

public class CDNEndpoints {
    private static final String BASE_URL = "https://cdn.discordapp.com";

    private static String createUrl(Object... paths) {
        StringBuilder finalUrl = new StringBuilder(BASE_URL);
        for (Object path : paths) {
            finalUrl.append("/").append(path.toString());
        }

        return finalUrl.toString();
    }

    public static String getAttachmentUrl(String channelId, String messageId, String attachmentId,
                                          String attachmentFileName) {
        return createUrl("attachments", channelId, messageId, attachmentId, attachmentFileName);
    }

    public static String getUserAvatarUrl(String userId, String userAvatar, CDNFileFormat format) {
        return createUrl("avatars", userId, userAvatar) + format;
    }

    public static String getUserAvatarUrl(String userId, String userAvatar, CDNFileFormat format, int size) {
        return getUserAvatarUrl(userId, userAvatar, format) + "?size=" + size;
    }

    public static String getUserAvatarDecorationUrl(String userId, String userAvatarDecoration, CDNFileFormat format) {
        return createUrl("avatar-decorations", userId, userAvatarDecoration) + format;
    }

    public static String getUserAvatarDecorationPresetUrl(String userAvatarDecoration, CDNFileFormat format) {
        return createUrl("avatar-decoration-presets", userAvatarDecoration) + format;
    }

    public static String getDefaultUserAvatarUrl(String userId) {
        long userIdLong = Long.parseLong(userId);
        return createUrl("embed", "avatars", userIdLong >> 22 % 6) + CDNFileFormat.PNG;
    }

    public static String getDefaultUserAvatarLegacyUrl(String tag) {
        int tagInteger = Integer.parseInt(tag);
        return createUrl("embed", "avatars", tagInteger % 5) + CDNFileFormat.PNG;
    }

    public static String getDefaultUserAvatarUrl(UserObject user) {
        boolean newUsername = user.getDiscriminator().get("0").equals("0");

        if (newUsername) {
            return getDefaultUserAvatarUrl(user.getId().get("0"));
        } else {
            return getDefaultUserAvatarLegacyUrl(user.getDiscriminator().get("0"));
        }
    }

    public static String getUserBannerUrl(String userId, String userBanner, CDNFileFormat format) {
        return createUrl("banners", userId, userBanner) + format;
    }

    public static String getChannelIconUrl(String channelId, String channelIcon, CDNFileFormat format) {
        return createUrl("channels", channelId, "icons", channelIcon) + format;
    }

    public static String getGuildIconUrl(String guildId, String guildIcon, CDNFileFormat format) {
        return createUrl("icons", guildId, guildIcon) + format;
    }

    public static String getGuildIconUrl(GuildObject guild, CDNFileFormat format) {
        return getGuildIconUrl(guild.getId().get("0"), guild.getIcon().get("0"), format);
    }

    public static String getGuildIconUrl(String guildId, String guildIcon, CDNFileFormat format, int size) {
        return getGuildIconUrl(guildId, guildIcon, format) + "?size=" + size;
    }

    public static String getGuildIconUrl(GuildObject guild, CDNFileFormat format, int size) {
        return getGuildIconUrl(guild, format) + "?size=" + size;
    }

    public static String getGuildSplashUrl(String guildId, String guildSplash, CDNFileFormat format) {
        return createUrl("splashes", guildId, guildSplash) + format;
    }

    public static String getGuildDiscoverySplashUrl(String guildId, String guildDiscoverySplash, CDNFileFormat format) {
        return createUrl("discovery-splashes", guildId, guildDiscoverySplash) + format;
    }

    public static String getGuildBannerUrl(String guildId, String guildBanner, CDNFileFormat format) {
        return createUrl("banners", guildId, guildBanner) + format;
    }

    public static String getGuildHomeHeaderUrl(String guildId, String guildHomeHeader, CDNFileFormat format) {
        return createUrl("guilds", guildId, "home-headers", guildHomeHeader) + format;
    }

    public static String getGuildScheduledEventCoverUrl(String eventId, String eventCoverImage, CDNFileFormat format) {
        return createUrl("guild-events", eventId, eventCoverImage) + format;
    }

    public static String getGuildMemberAvatarUrl(String guildId, String userId, String userAvatar,
                                                 CDNFileFormat format) {
        return createUrl("guilds", guildId, "users", userId, "avatars", userAvatar) + format;
    }

    public static String getGuildMemberBannerUrl(String guildId, String userId, String userBanner,
                                                 CDNFileFormat format) {
        return createUrl("guilds", guildId, "users", userId, "banners", userBanner) + format;
    }

    public static String getRoleIconUrl(String roleId, String roleIcon, CDNFileFormat format) {
        return createUrl("roles", roleId, "icons", roleIcon) + format;
    }

    public static String getCustomEmojiUrl(String emojiId, CDNFileFormat format) {
        return createUrl("emojis", emojiId) + format;
    }

    public static String getApplicationIconUrl(String applicationId, String icon, CDNFileFormat format) {
        return createUrl("app-icons", applicationId, icon) + format;
    }

    public static String getApplicationCoverUrl(String applicationId, String coverImage, CDNFileFormat format) {
        return createUrl("app-icons", applicationId, coverImage) + format;
    }

    public static String getApplicationSplashUrl(String applicationId, String splash, CDNFileFormat format) {
        return createUrl("app-icons", applicationId, splash) + format;
    }

    public static String getApplicationAssetUrl(String applicationId, String assetId, CDNFileFormat format) {
        return createUrl("app-assets", applicationId, assetId) + format;
    }

    public static String getApplicationDirectoryCollectionUrl(String itemId, String itemHash, CDNFileFormat format) {
        return createUrl("application-directory", "collection-items", itemId, itemHash) + format;
    }

    public static String getAchievementIconUrl(String applicationId, String achievementId, String iconHash,
                                               CDNFileFormat format) {
        return createUrl("app-assets", applicationId, "achievements", achievementId, "icons", iconHash)
                + format;
    }

    public static String getStickerPackBannerUrl(String id, String bannerAssetId, CDNFileFormat format) {
        return createUrl("app-assets", id, "store", bannerAssetId) + format;
    }

    public static String getTeamIconUrl(String teamId, String teamIcon, CDNFileFormat format) {
        return createUrl("team-icons", teamId, teamIcon) + format;
    }

    public static String getStickerUrl(String stickerId, CDNFileFormat format) {
        return createUrl("stickers", stickerId) + format;
    }

    public static String getStickerUrl(String stickerId, CDNFileFormat format, int size) {
        return getStickerUrl(stickerId, format) + "?size=" + size;
    }

    public static String getSoundboardSoundUrl(String soundId, CDNFileFormat format) {
        return createUrl("soundboard-sounds", soundId) + format;
    }

    public static String getVideoFilterUrl(String userId, String videoFilterId, String videoFilterAsset,
                                           CDNFileFormat format) {
        return createUrl("users", userId, "video-filter-assets", videoFilterId, videoFilterAsset) + format;
    }

    public static String getProfileBadgeUrl(String badgeIcon, CDNFileFormat format) {
        return createUrl("badge-icons", badgeIcon) + format;
    }
}
