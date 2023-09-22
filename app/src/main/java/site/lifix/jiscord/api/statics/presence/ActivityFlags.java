package site.lifix.jiscord.api.statics.presence;

public class ActivityFlags {
    public static final int INSTANCE = 1 << 0;
    public static final int JOIN = 1 << 1;
    public static final int SPECTATE = 1 << 2;
    public static final int JOIN_REQUEST = 1 << 3;
    public static final int SYNC = 1 << 4;
    public static final int PLAY = 1 << 5;
    public static final int PARTY_PRIVACY_FRIENDS = 1 << 6;
    public static final int PARTY_PRIVACY_VOICE_CHANNEL = 1 << 7;
    public static final int EMBEDDED = 1 << 8;
}
