package site.lifix.jiscord.api.objects.message;

import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class AttachmentObject extends BaseObject {
    // The attachment ID
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of file attached
    @Getter private final OptionalJsonValue<String> filename
            = new OptionalJsonValue<>(this, "filename", String.class);

    // The name of the file pre-uploaded to Discord's GCP bucket
    @Getter private final OptionalJsonValue<String> uploadedFilename
            = new OptionalJsonValue<>(this, "uploaded_filename", String.class);

    // The description for the file (max 1024 characters)
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The attachment's media type
    @Getter private final OptionalJsonValue<String> contentType
            = new OptionalJsonValue<>(this, "content_type", String.class);

    // The size of file in bytes
    @Getter private final OptionalJsonValue<Integer> size
            = new OptionalJsonValue<>(this, "size", Integer.class);

    // Source URL of the file
    @Getter private final OptionalJsonValue<String> url
            = new OptionalJsonValue<>(this, "url", String.class);

    // A proxied url of the file
    @Getter private final OptionalJsonValue<String> proxyUrl
            = new OptionalJsonValue<>(this, "proxy_url", String.class);

    // Height of file (if image)
    @Getter private final OptionalJsonValue<Integer> height
            = new OptionalJsonValue<>(this, "height", Integer.class);

    // Width of file (if image)
    @Getter private final OptionalJsonValue<Integer> width
            = new OptionalJsonValue<>(this, "width", Integer.class);

    // whether this attachment is ephemeral
    @Getter private final OptionalJsonValue<Boolean> ephemeral
            = new OptionalJsonValue<>(this, "ephemeral", Boolean.class);

    public AttachmentObject(JsonElement dataIn) {
        super(dataIn);
    }

    public AttachmentObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
