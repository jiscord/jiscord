package site.lifix.jiscord.api.objects.sticker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.OptionalJsonValue;
import site.lifix.jiscord.utility.Utility;

import java.util.List;

public class StickerPackObject extends BaseObject {
    // The ID of the sticker pack's banner image
    @Getter private final OptionalJsonValue<String> bannerAssetId
            = new OptionalJsonValue<>(this, "banner_asset_id", String.class);

    // The ID of a sticker in the pack which is shown as the pack's icon
    @Getter private final OptionalJsonValue<String> coverStickerId
            = new OptionalJsonValue<>(this, "cover_sticker_id", String.class);

    // The description for the sticker pack
    @Getter private final OptionalJsonValue<String> description
            = new OptionalJsonValue<>(this, "description", String.class);

    // The ID of the sticker pack
    @Getter private final OptionalJsonValue<String> id
            = new OptionalJsonValue<>(this, "id", String.class);

    // The name of the sticker pack
    @Getter private final OptionalJsonValue<String> name
            = new OptionalJsonValue<>(this, "name", String.class);

    // The ID of the pack's SKU
    @Getter private final OptionalJsonValue<String> skuId
            = new OptionalJsonValue<>(this, "sku_id", String.class);

    // The stickers in the pack
    private final OptionalJsonValue<JsonArray> stickers
            = new OptionalJsonValue<>(this, "stickers", JsonArray.class);

    public List<StickerObject> getStickers() {
        return Utility.mappedJsonArray(this.stickers, StickerObject::new);
    }

    public StickerPackObject(JsonElement data) {
        super(data);
    }

    public StickerPackObject(OptionalJsonValue<?> data) {
        super(data);
    }
}
