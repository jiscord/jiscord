package site.lifix.jiscord.api.statics.guild.permissions;

public class PermissionFlags {
    // Allows creation of instant invites
    public static final long CREATE_INSTANT_INVITE = 1L << 0L;

    // Allows kicking members
    public static final long KICK_MEMBERS = 1L << 1L;

    // Allows banning members
    public static final long BAN_MEMBERS = 1L << 2L;

    // Allows all permissions and bypasses channel permission overwrites
    public static final long ADMINISTRATOR = 1L << 3L;

    // Allows management and editing of channels
    public static final long MANAGE_CHANNELS = 1L << 4L;

    // Allows management and editing of the guild
    public static final long MANAGE_GUILD = 1L << 5L;

    // Allows for the addition of reactions to messages
    public static final long ADD_REACTIONS = 1L << 6L;

    // Allows for viewing of audit logs
    public static final long VIEW_AUDIT_LOG = 1L << 7L;

    // Allows for using priority speaker in a voice channel
    public static final long PRIORITY_SPEAKER = 1L << 8L;

    // Allows the user to go live
    public static final long STREAM = 1L << 9L;

    // Allows guild members to view a channel, which includes reading messages in text channels and joining voice channels
    public static final long VIEW_CHANNEL = 1L << 10L;

    // Allows for sending messages in a channel and creating threads in a forum (does not allow sending messages in threads)
    public static final long SEND_MESSAGES = 1L << 11L;

    // Allows for sending of /tts messages
    public static final long SEND_TTS_MESSAGES = 1L << 12L;

    // Allows for deletion of other users messages
    public static final long MANAGE_MESSAGES = 1L << 13L;

    // Links sent by users with this permission will be auto-embedded
    public static final long EMBED_LINKS = 1L << 14L;

    // Allows for uploading images and files
    public static final long ATTACH_FILES = 1L << 15L;

    // Allows for reading of message history
    public static final long READ_MESSAGE_HISTORY = 1L << 16L;

    // Allows for using the @everyone tag to notify all users in a channel, and the @here tag to notify all online users in a channel
    public static final long MENTION_EVERYONE = 1L << 17L;

    // Allows the usage of custom emojis from other servers
    public static final long USE_EXTERNAL_EMOJIS = 1L << 18L;

    // Allows for viewing guild insights
    public static final long VIEW_GUILD_INSIGHTS = 1L << 19L;

    // Allows for joining of a voice channel
    public static final long CONNECT = 1L << 20L;

    // Allows for speaking in a voice channel
    public static final long SPEAK = 1L << 21L;

    // Allows for muting members in a voice channel
    public static final long MUTE_MEMBERS = 1L << 22L;

    // Allows for deafening of members in a voice channel
    public static final long DEAFEN_MEMBERS = 1L << 23L;

    // Allows for moving of members between voice channels
    public static final long MOVE_MEMBERS = 1L << 24L;

    // Allows for using voice-activity-detection in a voice channel
    public static final long USE_VAD = 1L << 25L;

    // Allows for modification of own nickname
    public static final long CHANGE_NICKNAME = 1L << 26L;

    // Allows for modification of other users nicknames
    public static final long MANAGE_NICKNAMES = 1L << 27L;

    // Allows management and editing of roles
    public static final long MANAGE_ROLES = 1L << 28L;

    // Allows management and editing of webhooks
    public static final long MANAGE_WEBHOOKS = 1L << 29L;

    // Allows management and editing of emojis, stickers and soundboard sounds
    public static final long MANAGE_EXPRESSIONS = 1L << 30L;

    // Allows members to use application commands, including slash commands and context menu commands
    public static final long USE_APPLICATION_COMMANDS = 1L << 31L;

    // Allows for requesting to speak in stage channels
    public static final long REQUEST_TO_SPEAK = 1L << 32L;

    // Allows for creating, editing, and deleting scheduled events
    public static final long MANAGE_EVENTS = 1L << 33L;

    // Allows for deleting and archiving threads, and viewing all private threads
    public static final long MANAGE_THREADS = 1L << 34L;

    // Allows for creating public and announcement threads
    public static final long CREATE_PUBLIC_THREADS = 1L << 35L;

    // Allows for creating private threads
    public static final long CREATE_PRIVATE_THREADS = 1L << 36L;

    // Allows the usage of custom stickers from other servers
    public static final long USE_EXTERNAL_STICKERS = 1L << 37L;

    // Allows for sending messages in threads
    public static final long SEND_MESSAGES_IN_THREADS = 1L << 38L;

    // Allows for using Activities (applications with the EMBEDDED flag) in a voice channel
    public static final long USE_EMBEDDED_ACTIVITIES = 1L << 39;

    // Allows for timing out users to prevent them from sending or reacting to messages in chat and threads, and from speaking in voice and stage channels
    public static final long MODERATE_MEMBERS = 1L << 40L;

    // Allows for viewing guild role subscriptions insights
    public static final long VIEW_CREATOR_MONETIZATION_ANALYTICS = 1L << 41L;

    // Allows members to interact with the Clyde AI integration
    public static final long USE_CLYDE_AI = 1L << 47L;
}
