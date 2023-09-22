package site.lifix.jiscord.api.objects.user;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.integration.IntegrationObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class ConnectionObject extends BaseObject {
    // The access token for the connection account
    @Getter private final OptionalJsonValue<String> accessToken
            = new OptionalJsonValue<>(this, "access_token", String.class);

    // Whether friend sync is enabled for this connection
    @Getter private final OptionalJsonValue<Boolean> friendSync
            = new OptionalJsonValue<>(this, "friend_sync", Boolean.class);

    // ID of the connection account
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The guild integrations attached to the connection
    private final OptionalJsonValue<JsonArray> integrations
            = new OptionalJsonValue<>(this, "integrations", JsonArray.class);

    // Service-specific metadata about the connection
    @Getter private final OptionalJsonValue<JsonObject> metadata
            = new OptionalJsonValue<>(this, "metadata", JsonObject.class);

    // Visibility of the connection's metadata
    @Getter private final OptionalJsonValue<Integer> metadataVisibility
            = new OptionalJsonValue<>(this, "metadata_visibility", Integer.class);

    // The username of the connection account
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // Whether the connection is revoked
    @Getter private final OptionalJsonValue<Boolean> revoked
            = new OptionalJsonValue<>(this, "revoked", Boolean.class);

    // Whether activities related to this connection will be shown in presence
    @Getter private final OptionalJsonValue<Boolean> showActivity
            = new OptionalJsonValue<>(this, "show_activity", Boolean.class);

    // Whether this connection has a corresponding third party OAuth2 token
    @Getter private final OptionalJsonValue<Boolean> twoWayLink
            = new OptionalJsonValue<>(this, "two_way_link", Boolean.class);

    // The type of the connection
    @Getter private final OptionalJsonValue<String> type
            = new OptionalJsonValue<>(this, "type", String.class);

    // Whether the connection is verified
    @Getter private final OptionalJsonValue<Boolean> verified
            = new OptionalJsonValue<>(this, "verified", Boolean.class);

    // Visibility of the connection
    @Getter private final OptionalJsonValue<Integer> visibility
            = new OptionalJsonValue<>(this, "visibility", Integer.class);

    public List<IntegrationObject> getIntegrations() {
        return Utility.mappedJsonArray(this.integrations, IntegrationObject::new);
    }

    public ConnectionObject(JsonElement data) {
        super(data);
    }

    public ConnectionObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
