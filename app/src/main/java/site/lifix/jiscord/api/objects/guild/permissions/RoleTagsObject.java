package site.lifix.jiscord.api.objects.guild.permissions;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class RoleTagsObject extends BaseObject {
    // Whether this role is available for purchase
    @Getter private final OptionalJsonValue<Boolean> availableForPurchase
            = new OptionalJsonValue<>(this, "available_for_purchase", Boolean.class);

    // The ID of the bot this role belongs to
    @Getter private final OptionalJsonValue<String> botId
            = new OptionalJsonValue<>(this, "bot_id", String.class);

    // Whether this role is a guild's linked role
    @Getter private final OptionalJsonValue<Boolean> guildConnections
            = new OptionalJsonValue<>(this, "guild_connections", Boolean.class);

    // The ID of the integration this role belongs to
    @Getter private final OptionalJsonValue<String> integrationId
            = new OptionalJsonValue<>(this, "integration_id", String.class);

    // Whether this is the guild's premium subscriber (booster) role
    @Getter private final OptionalJsonValue<Boolean> premiumSubscriber
            = new OptionalJsonValue<>(this, "premium_subscriber", Boolean.class);

    // The ID of this role's subscription SKU and listing
    @Getter private final OptionalJsonValue<String> subscriptionListingId
            = new OptionalJsonValue<>(this, "subscription_listing_id", String.class);

    public RoleTagsObject(JsonElement data) {
        super(data);
    }

    public RoleTagsObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
