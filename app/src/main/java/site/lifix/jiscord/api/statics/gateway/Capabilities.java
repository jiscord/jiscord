package site.lifix.jiscord.api.statics.gateway;

public class Capabilities {
    // Removes the notes field from the Ready event,
    public static final int LAZY_USER_NOTES = 1 << 0;

    // Prevents member/presence syncing and Presence Update events for implicit relationships
    public static final int NO_AFFINE_USER_IDS = 1 << 1;

    // Enables versioned read states, changing the read_state field in the Ready event to an object, allowing it to
    //  be cached when re-identifying
    public static final int VERSIONED_READ_STATES = 1 << 2;

    // Enables versioned user guild settings, changing the user_guild_settings field in the Ready event to an object,
    //  allowing it to be cached when re-identifying
    public static final int VERSIONED_USER_GUILD_SETTINGS = 1 << 3;

    // Dehydrates the Ready payload, moving all user objects to the users field and replacing them in various places
    //  in the payload with user_id or recipient_id, and merging the members fields of all guilds into a single
    //  merged_members field
    public static final int DEDUPE_USER_OBJECTS = 1 << 4;

    // Separates the Ready payload into two parts (Ready and Ready Supplemental) allowing the client to receive the
    //  Ready payload faster and then receive the rest of the payload later; depends on DEDUPE_USER_OBJECTS
    public static final int PRIORITIZED_READY_PAYLOAD = 1 << 5;

    // Changes the populations entry of guild_experiments in the Ready event to be an array of populations rather than
    //  a single population
    public static final int MULTIPLE_GUILD_EXPERIMENT_POPULATIONS = 1 << 6;

    // Includes read states tied to non-channel resources (e.g. guild scheduled events and notification center) in the
    //  read_states field of the Ready event
    public static final int NON_CHANNEL_READ_STATES = 1 << 7;

    // Enables auth token refresh, allowing the client to optionally receive a new auth token in the auth_token field
    //  of the Ready event
    public static final int AUTH_TOKEN_REFRESH = 1 << 8;

    // Removes the user_settings field from the Ready event, and prevents User Settings Update events; the
    //  user_settings_proto field and User Settings Proto Update event is used instead
    public static final int USER_SETTINGS_PROTO = 1 << 9;

    // Enables client state caching v2
    public static final int CLIENT_STATE_V2 = 1 << 10;

    // Enables passive guild updates, allowing the client to receive Passive Update v1 events instead of Channel
    //  Unreads Update events for guilds it is not subscribed to
    public static final int PASSIVE_GUILD_UPDATE = 1 << 11;

    // This enum value is not known
    public static final int UNKNOWN = 1 << 12;
}
