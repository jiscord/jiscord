package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class HarvestObject extends BaseObject {
    // The time the harvest was completed
    @Getter private final OptionalJsonValue<String> completedAt
            = new OptionalJsonValue<>(this, "completed_at", String.class);

    // The time the harvest was created
    @Getter private final OptionalJsonValue<String> createdAt
            = new OptionalJsonValue<>(this, "created_at", String.class);

    // The ID of the harvest
    @Getter private final OptionalJsonValue<String> harvestId
            = new OptionalJsonValue<>(this, "harvest_id", String.class);

    // The time the harvest was last polled
    @Getter private final OptionalJsonValue<String> polledAt
            = new OptionalJsonValue<>(this, "polled_at", String.class);

    // The status of the harvest
    @Getter private final OptionalJsonValue<String> status
            = new OptionalJsonValue<>(this, "status", String.class);

    // The ID of the user being harvested
    @Getter private final OptionalJsonValue<Integer> userId
            = new OptionalJsonValue<>(this, "user_id", Integer.class);

    public HarvestObject(JsonElement data) {
        super(data);
    }

    public HarvestObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
