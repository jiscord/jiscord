package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.api.objects.message.embed.*;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class EmbedObject extends BaseObject {
    // The title of the embed (max 256)
    @Getter private final OptionalJsonValue<String> title
            = new OptionalJsonValue<>(this, "title", String.class);

    // The type of embed (always rich for sent embeds)
    @Getter private final OptionalJsonValue<String> type
            = new OptionalJsonValue<>(this, "type", String.class);

    // The description of the embed (max 4096)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The URL of the embed
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // Timestamp of embed content
    @Getter private final OptionalJsonValue<String> timestamp
            = new OptionalJsonValue<>(this, "timestamp", String.class);

    // The color of the embed encoded as an integer representation of hexadecimal color code
    @Getter private final OptionalJsonValue<Integer> color
            = new OptionalJsonValue<>(this, "color", Integer.class);

    // Embed footer information
    @Getter private final OptionalJsonValue<EmbedFooterObject> footer
            = new OptionalJsonValue<>(this, "footer", EmbedFooterObject.class);

    // Embed image information
    @Getter private final OptionalJsonValue<EmbedImageObject> image
            = new OptionalJsonValue<>(this, "image", EmbedImageObject.class);

    // Embed thumbnail information
    @Getter private final OptionalJsonValue<EmbedThumbnailObject> thumbnail
            = new OptionalJsonValue<>(this, "thumbnail", EmbedThumbnailObject.class);

    // Embed video information
    @Getter private final OptionalJsonValue<EmbedVideoObject> video
            = new OptionalJsonValue<>(this, "video", EmbedVideoObject.class);

    // Embed provider information
    @Getter private final OptionalJsonValue<EmbedProviderObject> provider
            = new OptionalJsonValue<>(this, "provider", EmbedProviderObject.class);

    // Embed author information
    @Getter private final OptionalJsonValue<EmbedAuthorObject> author
            = new OptionalJsonValue<>(this, "author", EmbedAuthorObject.class);

    // The fields of the embed (max 25)
    private final OptionalJsonValue<JsonArray> fields
            = new OptionalJsonValue<>(this, "fields", JsonArray.class);

    // The ID of the message this embed was generated from
    @Getter private final OptionalJsonValue<String> referenceId
            = new OptionalJsonValue<>(this, "reference_id", String.class);

    public List<EmbedFieldObject> getFields() {
        return Utility.mappedJsonArray(this.fields, EmbedFieldObject::new);
    }

    public EmbedObject(JsonElement dataIn) {
        super(dataIn);
    }

    public EmbedObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
