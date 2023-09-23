package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class MessageReferenceObject extends BaseObject {
    // The ID of the originating message
    @Getter private final OptionalJsonValue<String> messageId
            = new OptionalJsonValue<>(this, "message_id", String.class);

    // The ID of the originating channel
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // The ID of the originating channel's guild
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // Whether to error if the referenced message doesn't exist instead of sending as a normal (non-reply) message (send-only, default true)
    @Getter private final OptionalJsonValue<Boolean> failIfNotExists
            = new OptionalJsonValue<>(this, "fail_if_not_exists", Boolean.class);

    public MessageReferenceObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageReferenceObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
