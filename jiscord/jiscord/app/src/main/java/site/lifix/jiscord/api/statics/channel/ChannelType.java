package site.lifix.jiscord.api.statics.channel;

public class ChannelType {
    // A text channel within a guild
    public static final int GUILD_TEXT = 0;

    // A private channel between two users
    public static final int DM = 1;

    // A voice channel within a guild
    public static final int GUILD_VOICE = 2;

    // A private channel between multiple users
    public static final int GROUP_DM = 3;

    // An organizational category that contains up to 50 channels
    public static final int GUILD_CATEGORY = 4;

    // Almost identical to GUILD_TEXT, a channel that users can follow and crosspost into their own guild
    public static final int GUILD_NEWS = 5;

    // A channel in which game developers can sell their game on Discord
    public static final int GUILD_STORE = 6;

    // A channel where users can match up for various games
    public static final int GUILD_LFG = 7;

    // A private channel between multiple users for a group within an LFG channel
    public static final int LFG_GROUP_DM = 8;

    // The first iteration of the threads feature, never widely used
    public static final int THREAD_ALPHA = 9;

    // A temporary sub-channel within a GUILD_NEWS channel
    public static final int NEWS_THREAD = 10;

    // a temporary sub-channel within a GUILD_TEXT, GUILD_FORUM, or GUILD_MEDIA channel
    public static final int PUBLIC_THREAD = 11;

    // a temporary sub-channel within a GUILD_TEXT channel that is only viewable by those invited and those with the
    //  AMANAGE_THREADS permission
    public static final int PRIVATE_THREAD = 12;

    // A voice channel for hosting events with an audience in a guild
    public static final int GUILD_STAGE_VOICE = 13;

    // The main channel in a hub containing the listed guilds
    public static final int GUILD_DIRECTORY = 14;

    // A channel that can only contain threads
    public static final int GUILD_FORUM = 15;

    // A channel that can only contain threads in a gallery view
    public static final int GUILD_MEDIA = 16;
}
