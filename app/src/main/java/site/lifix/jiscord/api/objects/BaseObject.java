package site.lifix.jiscord.api.objects;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import site.lifix.jiscord.utility.OptionalJsonValue;

public class BaseObject implements IObject {
    protected final JsonObject data;

    public BaseObject(JsonElement dataIn) {
        JsonObject data = new JsonObject();
        if (!dataIn.isJsonNull() && dataIn.isJsonObject()) {
            data = dataIn.getAsJsonObject();
        }

        this.data = data;
    }

    public BaseObject(OptionalJsonValue<?> data) {
        JsonObject dataObject = new JsonObject();

        if (data.existsNonNull()) {
            Object dataFromOpt = data.get();
            if (dataFromOpt instanceof JsonObject) {
                dataObject = (JsonObject) dataFromOpt;
            }
        }

        this.data = dataObject;
    }

    public JsonObject data() {
        return this.data;
    }
}
