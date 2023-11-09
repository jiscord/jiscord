package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class ThreadMetadataObject extends BaseObject {
    // Whether the thread is archived
    @Getter private final OptionalJsonValue<Boolean> archived
            = new OptionalJsonValue<>(this, "archived", Boolean.class);

    // Timestamp when the thread's archive status was last changed, used for calculating recent activity
    @Getter private final OptionalJsonValue<String> archiveTimestamp
            = new OptionalJsonValue<>(this, "archive_timestamp", String.class);

    // Duration in minutes to stop showing in the channel list after inactivity (one of 60, 1440, 4320, 10080)
    @Getter private final OptionalJsonValue<Integer> autoArchiveDuration
            = new OptionalJsonValue<>(this, "auto_archive_duration", Integer.class);

    // Timestamp when the thread was created; only populated for threads created after 2022-01-09
    @Getter private final OptionalJsonValue<String> createTimestamp
            = new OptionalJsonValue<>(this, "create_timestamp", String.class);

    // Whether non-moderators can add other non-moderators to a thread; only available on private threads
    @Getter private final OptionalJsonValue<Boolean> invitable
            = new OptionalJsonValue<>(this, "invitable", Boolean.class);

    // Whether the thread is locked; when a thread is locked, only users with MANAGE_THREADS can unarchive it
    @Getter private final OptionalJsonValue<Boolean> locked
            = new OptionalJsonValue<>(this, "locked", Boolean.class);

    public ThreadMetadataObject(JsonElement data) {
        super(data);
    }

    public ThreadMetadataObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
