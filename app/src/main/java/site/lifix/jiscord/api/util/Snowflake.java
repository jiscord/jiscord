package site.lifix.jiscord.api.util;

import site.lifix.jiscord.utility.OptionalJsonValue;

public class Snowflake {
    private final long snowflakeId;

    private Snowflake(long snowflakeId) {
        this.snowflakeId = snowflakeId;
    }

    private Snowflake(String snowflakeId) {
        this(Long.parseLong(snowflakeId));
    }

    public static Snowflake from(long snowflakeId) {
        return new Snowflake(snowflakeId);
    }

    public static Snowflake from(String snowflakeId) {
        return new Snowflake(snowflakeId);
    }

    public static Snowflake from(OptionalJsonValue<String> snowflakeId) {
        return from(snowflakeId.get("0"));
    }

    // Milliseconds since Discord Epoch, the first second of 2015 (or 1420070400000).
    public long getTimestamp() {
        return (this.snowflakeId >> 22) + 1420070400000L;
    }

    public int getInternalWorkerId() {
        return (int) ((this.snowflakeId & 0x3E0000) >> 17);
    }

    public int getInternalProcessId() {
        return (int) ((this.snowflakeId & 0x1F000) >> 12);
    }

    // For every ID that is generated on that process, this number is incremented
    public int getIncrement() {
        return (int) (this.snowflakeId & 0xFFF);
    }

    public long get() {
        return this.snowflakeId;
    }

    public boolean equals(Object instance) {
        if (!(instance instanceof Snowflake)) {
            return false;
        }

        return ((Snowflake) instance).get() == this.get();
    }
}
