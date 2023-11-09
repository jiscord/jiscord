package site.lifix.jiscord.api.objects.integration;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.application.ApplicationSKUObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class IntegrationApplicationObject extends BaseObject {
    // The bot attached to this application
    @Getter private final OptionalJsonValue<UserObject> bot
            = new OptionalJsonValue<>(this, "bot", UserObject.class);

    // The application's default rich presence invite cover image hash
    @Getter private final OptionalJsonValue<String> coverImage
            = new OptionalJsonValue<>(this, "cover_image", String.class);

    // The URL used for deep linking during OAuth2 authorization on mobile devices
    @Getter private final OptionalJsonValue<String> deeplinkUri
            = new OptionalJsonValue<>(this, "deeplink_uri", String.class);

    // The description of the application
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The application's icon hash
    @Getter private final OptionalJsonValue<String> icon
            = new OptionalJsonValue<>(this, "icon", String.class);

    // The ID of the application
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the application
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The ID of the application's primary SKU (game, application subscription, etc.)
    @Getter private final OptionalJsonValue<String> primarySkuId
            = new OptionalJsonValue<>(this, "primary_sku_id", String.class);

    // The role connection verification entry point of the integration; when configured, this will render the
    //   application as a verification method in guild role verification configuration
    @Getter private final OptionalJsonValue<String> roleConnectionsVerificationUrl
            = new OptionalJsonValue<>(this, "role_connections_verification_url", String.class);

    // The application's splash hash
    @Getter private final OptionalJsonValue<String> splash
            = new OptionalJsonValue<>(this, "splash", String.class);

    // The third party SKUs of the application's game
    private final OptionalJsonValue<JsonArray> thirdPartySkus
            = new OptionalJsonValue<>(this, "third_party_skus", JsonArray.class);

    // The type of the application, if any
    @Getter private final OptionalJsonValue<Integer> type
            = new OptionalJsonValue<>(this, "type", Integer.class);

    public List<ApplicationSKUObject> getThirdPartySkus() {
        return Utility.mappedJsonArray(this.thirdPartySkus, ApplicationSKUObject::new);
    }

    public IntegrationApplicationObject(JsonElement data) {
        super(data);
    }

    public IntegrationApplicationObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
