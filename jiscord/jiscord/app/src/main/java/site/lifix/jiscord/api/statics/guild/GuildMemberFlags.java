package site.lifix.jiscord.api.statics.guild;

public class GuildMemberFlags {
    // This guild member has left and rejoined the guild
    public static final int DID_REJOIN = 1 << 0;

    // This guild member has completed onboarding
    public static final int COMPLETED_ONBOARDING = 1 << 1;

    // This guild member bypasses guild verification requirements
    public static final int BYPASSES_VERIFICATION = 1 << 2;

    // This guild member has started onboarding
    public static final int STARTED_ONBOARDING = 1 << 3;

    // This guild member is a guest and not a true member
    public static final int GUEST = 1 << 4;

    // This guild member has been indefinitely quarantined by an AutoMod Rule for their username, display name, or
    //  nickname; quarantined users, similar to timed out users, are prevented from interacting with the guild in any
    //  way
    public static final int AUTOMOD_QUARANTINED_NAME = 1 << 7;

    // This guild member has been indefinitely quarantined by an AutoMod Rule for their bio; quarantined users, similar
    //  to timed out users, are prevented from interacting with the guild in any way
    public static final int AUTOMOD_QUARANTINED_BIO = 1 << 8;
}
