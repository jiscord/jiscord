package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class MessageRoleSubscriptionObject extends BaseObject {
    // The ID of the sku and listing that the user is subscribed to
    @Getter private final OptionalJsonValue<String> roleSubscriptionListingId
            = new OptionalJsonValue<>(this, "role_subscription_listing_id", String.class);

    // The name of the tier that the user is subscribed to
    @Getter private final OptionalJsonValue<String> tierName
            = new OptionalJsonValue<>(this, "tier_name", String.class);

    // The cumulative number of months that the user has been subscribed for
    @Getter private final OptionalJsonValue<Integer> totalMonthsSubscribed
            = new OptionalJsonValue<>(this, "total_months_subscribed", Integer.class);

    // Whether this notification is for a renewal rather than a new purchase
    @Getter private final OptionalJsonValue<Boolean> isRenewal
            = new OptionalJsonValue<>(this, "is_renewal", Boolean.class);

    public MessageRoleSubscriptionObject(JsonElement dataIn) {
        super(dataIn);
    }

    public MessageRoleSubscriptionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
