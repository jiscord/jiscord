package site.lifix.jiscord.utility;

public class CallOnce {
    private boolean called = false;

    public void exec(Runnable runnable) {
        if (!this.called) {
            runnable.run();
            this.called = true;
        }
    }
}
