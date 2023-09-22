package site.lifix.jiscord.ui.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.lifix.jiscord.ui.elements.impl.ServerListElement;
import site.lifix.jiscord.utility.ValidatedValue;

import java.util.HashMap;
import java.util.Map;

public class StaticTextures {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class TextureData {
        private String url;
        private int id;
        private boolean loaded;
    }

    private static final Map<String, TextureData> textures = new HashMap<>();

    public static boolean exists(String url) {
        return textures.containsKey(url);
    }

    public static ValidatedValue<Integer> getTexture(String url, int imageWidth, int imageHeight) {
        byte[] iconData = ImageCache.getImageData(url);

        if (exists(url)) {
            return ValidatedValue.from(textures.get(url).getId(), true);
        }

        if (iconData.length != 0) {
            if (!exists(url)) {
                Images.ImageData data = Images.loadTexture(iconData, imageWidth, imageHeight);

                if (data.isSuccess()) {
                    System.out.println("Texture added to map: " + url + ", " + data.getTextureId() + ", "
                            + data.getData().length);
                    textures.put(url, new TextureData(url, data.getTextureId(), true));
                    return ValidatedValue.from(data.getTextureId(), true);
                }
            }
        }

        return ValidatedValue.from(-1, false);
    }
}
