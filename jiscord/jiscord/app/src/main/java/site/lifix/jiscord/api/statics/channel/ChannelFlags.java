package site.lifix.jiscord.api.statics.channel;

public class ChannelFlags {
    // This guild channel has been removed from the guild's feed
    public static final int GUILD_FEED_REMOVED = 1 << 0;

    // This thread is pinned to the top of its parent thread-only channel
    public static final int PINNED = 1 << 1;

    // This guild channel has been removed from the guild's active channels
    public static final int ACTIVE_CHANNELS_REMOVED = 1 << 2;

    // This thread-only channel requires a tag to create threads in
    public static final int REQUIRE_TAG = 1 << 4;

    // This channel is marked as spam
    public static final int SPAM = 1 << 5;

    // This guild channel is used as a read-only resource for onboarding and is not shown in the channel list
    public static final int GUILD_RESOURCE_CHANNEL = 1 << 7;

    // This thread is created by Clyde AI, which has full access to all message content
    public static final int CLYDE_AI = 1 << 8;

    // This guild channel is scheduled for deletion and is not shown in the UI
    public static final int SCHEDULED_FOR_DELETION = 1 << 9;

    // This forum channel is a media channel
    public static final int MEDIA_CHANNEL = 1 << 10;

    // This guild channel has summaries disabled
    public static final int SUMMARIES_DISABLED = 1 << 11;

    // This private channel's recipients consented to the application shelf
    public static final int APPLICATION_SHELF_CONSENT = 1 << 12;

    // This role subscription tier for this guild channel has not been published yet
    public static final int ROLE_SUBSCRIPTION_TEMPLATE_PREVIEW_CHANNEL = 1 << 13;

    // This group DM is used for broadcasting a live stream
    public static final int BROADCASTING = 1 << 14;

    // This media channel has the embedded download options hidden for media attachments
    public static final int HIDE_MEDIA_DOWNLOAD_OPTIONS = 1 << 15;
}
