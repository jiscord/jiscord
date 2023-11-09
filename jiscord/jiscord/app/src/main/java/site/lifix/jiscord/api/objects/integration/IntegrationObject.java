package site.lifix.jiscord.api.objects.integration;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class IntegrationObject extends BaseObject {
    // Integration account information
    @Getter private final OptionalJsonValue<IntegrationObject> account
            = new OptionalJsonValue<>(this, "account", IntegrationObject.class);

    // The integrated OAuth2 application
    @Getter private final OptionalJsonValue<IntegrationApplicationObject> application
            = new OptionalJsonValue<>(this, "application", IntegrationApplicationObject.class);

    // Whether emoticons should be synced for this integration (Twitch only)
    @Getter private final OptionalJsonValue<Boolean> enableEmoticons
            = new OptionalJsonValue<>(this, "enable_emoticons", Boolean.class);

    // Whether this integration is enabled
    @Getter private final OptionalJsonValue<Boolean> enabled
            = new OptionalJsonValue<>(this, "enabled", Boolean.class);

    // The behavior of expiring subscribers
    @Getter private final OptionalJsonValue<Integer> expireBehavior
            = new OptionalJsonValue<>(this, "expire_behavior", Integer.class);

    // The grace period before expiring subscribers (one of 1, 3, 7, 14, 30, in days)
    @Getter private final OptionalJsonValue<Integer> expireGracePeriod
            = new OptionalJsonValue<>(this, "expire_grace_period", Integer.class);

    // The ID of the integration
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the integration
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Whether this integration has been revoked
    @Getter private final OptionalJsonValue<Boolean> revoked
            = new OptionalJsonValue<>(this, "revoked", Boolean.class);

    // Role ID that this integration uses for subscribers
    @Getter private final OptionalJsonValue<String> roleId
            = new OptionalJsonValue<>(this, "role_id", String.class);

    // How many subscribers this integration has
    @Getter private final OptionalJsonValue<Integer> subscriberCount
            = new OptionalJsonValue<>(this, "subscriber_count", Integer.class);

    // When this integration was last synced
    @Getter private final OptionalJsonValue<String> syncedAt
            = new OptionalJsonValue<>(this, "synced_at", String.class);

    // Whether this integration is syncing
    @Getter private final OptionalJsonValue<Boolean> syncing
            = new OptionalJsonValue<>(this, "syncing", Boolean.class);

    // The type of integration
    @Getter private final OptionalJsonValue<String> type
            = new OptionalJsonValue<>(this, "type", String.class);

    public IntegrationObject(JsonElement data) {
        super(data);
    }

    public IntegrationObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
