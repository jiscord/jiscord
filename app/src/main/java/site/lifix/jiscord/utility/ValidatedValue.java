package site.lifix.jiscord.utility;

public interface ValidatedValue<T> {
    T get();
    boolean valid();

    static <A> ValidatedValue<A> from(A value, boolean valid) {
        return new ValidatedValue<A>() {
            public A get() {
                return value;
            }

            public boolean valid() {
                return valid;
            }
        };
    }
}
