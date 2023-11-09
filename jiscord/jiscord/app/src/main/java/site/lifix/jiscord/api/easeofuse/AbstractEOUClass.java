package site.lifix.jiscord.api.easeofuse;

public abstract class AbstractEOUClass<T> {
    protected final T nativeObject;

    public AbstractEOUClass(T nativeObject) {
        this.nativeObject = nativeObject;
    }

    public T getNativeObject() {
        return this.nativeObject;
    }
}
