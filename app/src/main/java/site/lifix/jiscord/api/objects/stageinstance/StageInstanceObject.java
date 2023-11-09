package site.lifix.jiscord.api.objects.stageinstance;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class StageInstanceObject extends BaseObject {
    // The ID of the stage instance
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The guild ID of the associated stage channel
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The ID of the associated stage channel
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // The topic of the stage instance (1-120 characters)
    @Getter private final OptionalJsonValue<String> topic
            = new OptionalJsonValue<>(this, "topic", String.class);

    // The privacy level of the stage instance
    @Getter private final OptionalJsonValue<Integer> privacyLevel
            = new OptionalJsonValue<>(this, "privacy_level", Integer.class);

    // The invite code that can be used to join the stage channel, if the stage instance is public
    @Getter private final OptionalJsonValue<String> inviteCode
            = new OptionalJsonValue<>(this, "invite_code", String.class);

    // Whether or not stage Discovery is disabled
    @Getter private final OptionalJsonValue<Boolean> discoverableDisabled
            = new OptionalJsonValue<>(this, "discoverable_disabled", Boolean.class);

    // The ID of the scheduled event for this stage instance
    @Getter private final OptionalJsonValue<String> guildScheduledEventId
            = new OptionalJsonValue<>(this, "guild_scheduled_event_id", String.class);

    public StageInstanceObject(JsonElement dataIn) {
        super(dataIn);
    }

    public StageInstanceObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
