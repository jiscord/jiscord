package site.lifix.jiscord.api.statics.guildscheduledevent;

public class GuildScheduledEventStatus {
    // The scheduled event has not started yet
    public static final int SCHEDULED = 1;

    // The scheduled event is currently active
    public static final int ACTIVE = 2;

    // The scheduled event has ended
    public static final int COMPLETED = 3;

    // The scheduled event was canceled
    public static final int CANCELED = 4;
}
