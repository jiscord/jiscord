package site.lifix.jiscord.ui.utility;

public class LerpingFloat {
    private float target;
    private float current;
    private float speed;

    public LerpingFloat(float current, float speed) {
        this.current = current;
        this.target = current;
        this.speed = speed;
    }

    public LerpingFloat update(float speed) {
        if (this.speed != speed && speed != 0.f) {
            this.speed = speed;
        }

        if (this.current != this.target) {
            this.current = this.current * (1 - this.speed) + this.target * this.speed;
        }
        else if (this.current > this.target - 0.0005 && this.current < this.target + 0.0005) {
            this.current = this.target;
        }

        return this;
    }

    public LerpingFloat update() {
        return this.update(0.f);
    }

    public LerpingFloat setTarget(float target) {
        this.target = target;
        return this;
    }

    public LerpingFloat setCurrent(float current) {
        this.current = current;
        return this;
    }

    public float getCurrent() {
        return this.current;
    }
}
