package site.lifix.jiscord.utility;

public class PermanentValue<T> {
    private T value;
    private final CallOnce onceFlag = new CallOnce();

    public void set(TypedRunnable<T> runnable) {
        this.onceFlag.exec(() -> this.value = runnable.accept());
    }

    public T get() {
        return this.value;
    }
}
