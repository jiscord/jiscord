package site.lifix.jiscord.api.statics.guild;

public class VerificationLevel {
    // Unrestricted
    public static final int NONE = 0;

    // Must have a verified email on file
    public static final int LOW = 1;

    // Must be registered on Discord for longer than 5 minutes
    public static final int MEDIUM = 2;

    // Must be a member of the server for longer than 10 minutes
    public static final int HIGH = 3;

    // Must have a verified phone number on file
    public static final int VERY_HIGH = 4;
}
