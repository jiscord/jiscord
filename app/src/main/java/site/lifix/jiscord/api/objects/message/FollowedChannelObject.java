package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class FollowedChannelObject extends BaseObject {
    // The source channel ID
    @Getter private final OptionalJsonValue<String> channelId
            = new OptionalJsonValue<>(this, "channel_id", String.class);

    // Created target webhook ID
    @Getter private final OptionalJsonValue<String> webhookId
            = new OptionalJsonValue<>(this, "webhook_id", String.class);

    public FollowedChannelObject(JsonElement dataIn) {
        super(dataIn);
    }

    public FollowedChannelObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
