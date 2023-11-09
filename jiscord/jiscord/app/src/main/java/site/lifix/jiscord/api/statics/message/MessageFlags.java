package site.lifix.jiscord.api.statics.message;

public class MessageFlags {
    // This message has been published to subscribed channels (via Channel Following)
    public static final int CROSSPOSTED = 1 << 0;

    // This message originated from a message in another channel (via Channel Following)
    public static final int IS_CROSSPOST = 1 << 1;

    // Embeds will not be included when serializing this message
    public static final int SUPPRESS_EMBEDS = 1 << 2;

    // The source message for this crosspost has been deleted (via Channel Following)
    public static final int SOURCE_MESSAGE_DELETED = 1 << 3;

    // This message came from the urgent message system
    public static final int URGENT = 1 << 4;

    // This message has an associated thread, with the same ID as the message
    public static final int HAS_THREAD = 1 << 5;

    // This message is only visible to the user who invoked the interaction
    public static final int EPHEMERAL = 1 << 6;

    // This message is an interaction response and the bot is "thinking"
    public static final int LOADING = 1 << 7;

    // Some roles were not mentioned and added to the thread
    public static final int FAILED_TO_MENTION_SOME_ROLES_IN_THREAD = 1 << 8;

    // This message contains a link that impersonates Discord
    public static final int SHOULD_SHOW_LINK_NOT_DISCORD_WARNING = 1 << 10;

    // This message will not trigger push and desktop notifications
    public static final int SUPPRESS_NOTIFICATIONS = 1 << 12;

    // This message's audio attachments are rendered as voice messages
    public static final int VOICE_MESSAGE = 1 << 13;
}
