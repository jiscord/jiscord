package site.lifix.jiscord.api.easeofuse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import site.lifix.jiscord.utility.CustomRunnable;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayEOU extends AbstractEOUClass<JsonArray> {
    public JsonArrayEOU() {
        this(new JsonArray());
    }

    public JsonArrayEOU(JsonArray nativeObject) {
        super(nativeObject);
    }

    public <T> JsonArrayEOU add(T value) {
        if (value == null) {
            this.nativeObject.add(JsonNull.INSTANCE);
        } else if (value instanceof JsonElement) {
            this.nativeObject.add((JsonElement) value);
        } else if (value instanceof JsonObjectEOU) {
            this.nativeObject.add(((JsonObjectEOU) value).getNativeObject());
        } else if (value instanceof JsonArrayEOU) {
            this.nativeObject.add(((JsonArrayEOU) value).getNativeObject());
        } else if (value instanceof Number) {
            this.nativeObject.add(new JsonPrimitive((Number) value));
        } else if (value instanceof String) {
            this.nativeObject.add(new JsonPrimitive((String) value));
        } else if (value instanceof Boolean) {
            this.nativeObject.add(new JsonPrimitive((Boolean) value));
        } else if (value instanceof Character) {
            this.nativeObject.add(new JsonPrimitive((Character) value));
        }

        return this;
    }

    public <T> List<T> mapped(CustomRunnable<T, JsonElement> conversion) {
        List<T> list = new ArrayList<>();
        if (this.nativeObject != null && !this.nativeObject.isJsonNull() && this.nativeObject.isJsonArray()) {
            JsonArray jsonArray = this.nativeObject.getAsJsonArray();
            for (int x = 0; x < jsonArray.size(); x++) {
                JsonElement item = jsonArray.get(x);
                if (item != null && !item.isJsonNull()) {
                    list.add(conversion.run(item));
                }
            }
        }

        return list;
    }

    public String string() {
        return this.nativeObject.toString();
    }
}

