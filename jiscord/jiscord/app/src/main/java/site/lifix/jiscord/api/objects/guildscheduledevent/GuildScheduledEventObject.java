package site.lifix.jiscord.api.objects.guildscheduledevent;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class GuildScheduledEventObject extends BaseObject {
    // The ID of the scheduled event
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The ID of the guild the scheduled event belongs to
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The ID of the channel in which the scheduled event will be hosted
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // The ID of the user that created the scheduled event
    @Getter private final OptionalJsonValue<String> creatorId
            = new OptionalJsonValue<>(this, "creator_id", String.class);

    // The user that created the scheduled event
    @Getter private final OptionalJsonValue<UserObject> creator
            = new OptionalJsonValue<>(this, "creator", UserObject.class);

    // The name of the scheduled event (1-100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The description for the scheduled event (1-1000 characters)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // When the scheduled event will start
    @Getter private final OptionalJsonValue<String> scheduledStartTime
            = new OptionalJsonValue<>(this, "scheduled_start_time", String.class);

    // When the scheduled event will end
    @Getter private final OptionalJsonValue<String> scheduledEndTime
            = new OptionalJsonValue<>(this, "scheduled_end_time", String.class);

    // The privacy level of the scheduled event
    @Getter private final OptionalJsonValue<Integer> privacyLevel
            = new OptionalJsonValue<>(this, "privacy_level", Integer.class);

    // The status of the scheduled event
    @Getter private final OptionalJsonValue<Integer> status
            = new OptionalJsonValue<>(this, "status", Integer.class);

    // The type of scheduled event
    @Getter private final OptionalJsonValue<Integer> entityType
            = new OptionalJsonValue<>(this, "entity_type", Integer.class);

    // The ID of an entity associated with the scheduled event
    @Getter private final OptionalJsonValue<String> entityId
            = new OptionalJsonValue<>(this, "entity_id", String.class);

    // Additional metadata for the scheduled event
    @Getter private final OptionalJsonValue<GuildScheduledEventEntityMetadataObject> entityMetadata
            = new OptionalJsonValue<>(this, "entity_metadata",
            GuildScheduledEventEntityMetadataObject.class);

    // The number of users subscribed to the scheduled event
    @Getter private final OptionalJsonValue<Integer> userCount
            = new OptionalJsonValue<>(this, "user_count", Integer.class);

    // The cover image hash for the scheduled event
    @Getter private final OptionalJsonValue<String> image
            = new OptionalJsonValue<>(this, "image", String.class);

    public GuildScheduledEventObject(JsonElement dataIn) {
        super(dataIn);
    }

    public GuildScheduledEventObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
