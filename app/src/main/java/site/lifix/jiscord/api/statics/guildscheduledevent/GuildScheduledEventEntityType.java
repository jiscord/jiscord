package site.lifix.jiscord.api.statics.guildscheduledevent;

public class GuildScheduledEventEntityType {
    // The scheduled event is in a stage channel
    public static final int STAGE_INSTANCE = 1;

    // The scheduled event is in a voice channel
    public static final int VOICE = 2;

    // The scheduled event is somewhere else™ not associated with Discord
    public static final int EXTERNAL = 3;
}
