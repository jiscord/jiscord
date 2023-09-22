package site.lifix.jiscord.utility;

import com.google.gson.JsonObject;
import site.lifix.jiscord.api.easeofuse.JsonObjectEOU;
import site.lifix.jiscord.api.objects.IObject;

public class OptionalJsonValue<T> {
    private final JsonObject parent;
    private final String key;
    private final Class<T> type;

    public OptionalJsonValue(JsonObject parent, String key, Class<T> type) {
        this.parent = parent;
        this.key = key;
        this.type = type;
    }

    public OptionalJsonValue(IObject parent, String key, Class<T> type) {
        this(parent.data(), key, type);
    }

    public boolean exists() {
        return this.parent.has(this.key);
    }

    public boolean existsNonNull() {
        return this.exists() && !this.parent.get(this.key).isJsonNull();
    }

    public T get() {
        return new JsonObjectEOU(this.parent).get(this.key, this.type);
    }

    public T get(T expectedValue) {
        return new JsonObjectEOU(this.parent).get(this.key, this.type, expectedValue);
    }
}
