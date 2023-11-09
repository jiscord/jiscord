package site.lifix.jiscord.api.objects.gateway;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.presence.PresenceObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class MergedPresencesObject extends BaseObject {
    // Presences of the user's friends and implicit relationships (depending on the NO_AFFINE_USER_IDS Gateway capability)
    private final OptionalJsonValue<JsonArray> friends
            = new OptionalJsonValue<>(this, "friends", JsonArray.class);

    // Presences of the user's guilds, in the same order as the guilds array in Ready
    private final OptionalJsonValue<JsonArray> guilds
            = new OptionalJsonValue<>(this, "guilds", JsonArray.class);

    public List<PresenceObject> getFriends() {
        return Utility.mappedJsonArray(this.friends, PresenceObject::new);
    }

    public List<List<PresenceObject>> getGuilds() {
        List<List<PresenceObject>> all = new ArrayList<>();

        List<JsonArray> listOfArrays = Utility.mappedJsonArray(this.guilds, JsonElement::getAsJsonArray);
        for (JsonArray array : listOfArrays) {
            all.add(Utility.mappedJsonArray(array, PresenceObject::new));
        }

        return all;
    }

    public MergedPresencesObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MergedPresencesObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
