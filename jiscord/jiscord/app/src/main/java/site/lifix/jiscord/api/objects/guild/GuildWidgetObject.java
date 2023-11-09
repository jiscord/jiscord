package site.lifix.jiscord.api.objects.guild;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

    @SuppressWarnings("unused")
public class GuildWidgetObject extends BaseObject {
    // The public voice and stage channels in the guild
    private final OptionalJsonValue<JsonArray> channels
            = new OptionalJsonValue<>(this, "channels", JsonArray.class);

    // The ID of the guild the widget is for
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The invite URL for the guild's widget channel, if any
    @Getter private final OptionalJsonValue<String> instantInvite
            = new OptionalJsonValue<>(this, "instant_invite", String.class);

    // The non-offline guild members (max 100)
    private final OptionalJsonValue<JsonArray> members
            = new OptionalJsonValue<>(this, "members", JsonArray.class);

    // The name of the guild the widget is for
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Approximate count of non-offline members in the guild
    @Getter private final OptionalJsonValue<Integer> presenceCount
            = new OptionalJsonValue<>(this, "presence_count", Integer.class);

    public List<GuildWidgetChannelObject> getChannels() {
        return Utility.mappedJsonArray(this.channels, GuildWidgetChannelObject::new);
    }

    public List<GuildWidgetMemberObject> getMembers() {
        return Utility.mappedJsonArray(this.channels, GuildWidgetMemberObject::new);
    }

    public GuildWidgetObject(JsonElement data) {
        super(data);
    }

    public GuildWidgetObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
