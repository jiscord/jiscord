package site.lifix.jiscord.api.objects.channel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class PartialChannelObject extends BaseObject {
    // The group DM's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // The ID of the channel
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The ID of the guild the channel is in
    @Getter private final OptionalJsonValue<String> guildId
            = new OptionalJsonValue<>(this, "guild_id", String.class);

    // The name of the channel (1-100 characters)
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The recipients of the DM; only the username field is present
    private final OptionalJsonValue<JsonArray> recipients
            = new OptionalJsonValue<>(this, "recipients", JsonArray.class);

    // The type of channel
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    public List<UserObject> getRecipients() {
        return Utility.mappedJsonArray(this.recipients, UserObject::new);
    }

    public PartialChannelObject(JsonElement data) {
        super(data);
    }

    public PartialChannelObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
