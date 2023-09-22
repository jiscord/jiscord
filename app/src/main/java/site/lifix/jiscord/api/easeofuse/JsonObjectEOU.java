package site.lifix.jiscord.api.easeofuse;

import com.google.gson.*;
import site.lifix.jiscord.api.objects.BaseObject;
import site.lifix.jiscord.utility.Utility;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonObjectEOU extends AbstractEOUClass<JsonObject> {
    public JsonObjectEOU() {
        this(new JsonObject());
    }

    public JsonObjectEOU(JsonObject nativeObject) {
        super(nativeObject);
    }

    public <T> JsonObjectEOU add(String key, T value) {
        if (value == null) {
            this.nativeObject.add(key, JsonNull.INSTANCE);
        } else if (value instanceof JsonElement) {
            this.nativeObject.add(key, (JsonElement) value);
        } else if (value instanceof JsonObjectEOU) {
            this.nativeObject.add(key, ((JsonObjectEOU) value).getNativeObject());
        } else if (value instanceof Number) {
            this.nativeObject.addProperty(key, (Number) value);
        } else if (value instanceof String) {
            this.nativeObject.addProperty(key, (String) value);
        } else if (value instanceof Boolean) {
            this.nativeObject.addProperty(key, (Boolean) value);
        } else if (value instanceof Character) {
            this.nativeObject.addProperty(key, (Character) value);
        }

        return this;
    }

    public boolean has(String key) {
        return this.nativeObject.has(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> typedClass, T expectedValue) {
        Object value = null;
        if (this.has(key)) {
            JsonElement elem = this.nativeObject.get(key);

            if (!elem.isJsonNull()) {
                if (Utility.classEq(typedClass, JsonArray.class)) {
                    value = elem.getAsJsonArray();
                } else if (Utility.classEq(typedClass, JsonNull.class)) {
                    value = elem.getAsJsonNull();
                } else if (Utility.classEq(typedClass, JsonObject.class)) {
                    value = elem.getAsJsonObject();
                } else if (Utility.classEq(typedClass, JsonPrimitive.class)) {
                    value = elem.getAsJsonPrimitive();
                } else if (Utility.classEq(typedClass, BigDecimal.class)) {
                    value = elem.getAsBigDecimal();
                } else if (Utility.classEq(typedClass, BigInteger.class)) {
                    value = elem.getAsBigInteger();
                } else if (Utility.classEq(typedClass, Boolean.class)) {
                    value = elem.getAsBoolean();
                } else if (Utility.classEq(typedClass, Byte.class)) {
                    value = elem.getAsByte();
                } else if (Utility.classEq(typedClass, Double.class)) {
                    value = elem.getAsDouble();
                } else if (Utility.classEq(typedClass, Float.class)) {
                    value = elem.getAsFloat();
                } else if (Utility.classEq(typedClass, Integer.class)) {
                    value = elem.getAsInt();
                } else if (Utility.classEq(typedClass, Long.class)) {
                    value = elem.getAsLong();
                } else if (Utility.classEq(typedClass, Short.class)) {
                    value = elem.getAsShort();
                } else if (Utility.classEq(typedClass, Number.class)) {
                    value = elem.getAsNumber();
                } else if (Utility.classEq(typedClass, String.class)) {
                    value = elem.getAsString();
                } else if (Utility.classEq(typedClass, JsonObjectEOU.class)) {
                    if (elem.getAsJsonObject() == null) {
                        value = new JsonObjectEOU();
                    } else {
                        value = new JsonObjectEOU(elem.getAsJsonObject());
                    }
                } else if (Utility.classEq(typedClass.getSuperclass(), BaseObject.class)) {
                    try {
                        Constructor<?> constructor = typedClass.getConstructor(JsonElement.class);

                        if (elem.getAsJsonObject() == null) {
                            value = constructor.newInstance(new JsonObject());
                        } else {
                            value = constructor.newInstance(elem.getAsJsonObject());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (value != null) {
            return (T) value;
        }

        return expectedValue;
    }

    public <T> T get(String key, Class<T> typedClass) {
        return this.get(key, typedClass, null);
    }

    public String string() {
        return this.nativeObject.toString();
    }
}
