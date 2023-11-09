package site.lifix.jiscord.api.statics.channel;

public class ThreadMemberFlags {
    // The user has interacted with the thread
    public static final int HAS_INTERACTED = 1 << 0;

    // The user receives notifications for all messages
    public static final int ALL_MESSAGES = 1 << 1;

    // The user receives notifications only for messages that @mention them
    public static final int ONLY_MENTIONS = 1 << 2;

    // The user does not receive any notifications
    public static final int NO_MESSAGES = 1 << 3;
}
