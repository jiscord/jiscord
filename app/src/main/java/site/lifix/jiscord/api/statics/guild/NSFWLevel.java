package site.lifix.jiscord.api.statics.guild;

public class NSFWLevel {
    // Guild is not yet rated by Discord
    public static final int DEFAULT = 0;

    // Guild has mature content only suitable for users over 18
    public static final int EXPLICIT = 1;

    // Guild is safe for work
    public static final int SAFE = 2;

    // Guild has mildly mature content that may not be suitable for users under 18
    public static final int AGE_RESTRICTED = 3;
}
