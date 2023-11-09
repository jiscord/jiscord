package site.lifix.jiscord.api.statics.cdn;

import lombok.Getter;

@Getter
public enum CDNFileFormat {
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    WEBP("webp"),
    GIF("gif"),
    LOTTIE("json"),
    MP3("mp3"),
    OGG("ogg");

    private final String extension;
    CDNFileFormat(String extension) {
        this.extension = extension;
    }

    public String toString() {
        return "." + this.extension;
    }
}
