package site.lifix.jiscord.ui.notifications;

import imgui.ImGui;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.utility.LerpingFloat;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class NotificationManager {
    private static class NotificationRenderer {
        private final long startTime;
        private final Notification notification;
        private final LerpingFloat lerpingX = new LerpingFloat(400.f, 0.1414f);
        private final LerpingFloat lerpingY = new LerpingFloat(-1.f, 0.1414f);

        public NotificationRenderer(Notification notification) {
            this.startTime = System.currentTimeMillis();
            this.notification = notification;
        }

        public boolean timePassed(long millis) {
            return System.currentTimeMillis() >= this.startTime + millis;
        }

        public void setTarget(float x, float y) {
            this.lerpingX.setTarget(x);
            this.lerpingY.setTarget(y);
        }

        public void update() {
            this.lerpingX.update();
            this.lerpingY.update();
        }

        public float render(float x, float y) {
            long timePassed = System.currentTimeMillis() - this.startTime;
            long timeRemaining = (this.startTime + 5000) - System.currentTimeMillis();
            int opacity = timePassed < 255 && timePassed > 0 ? (int) timePassed
                    : (timeRemaining < 255 && timeRemaining > 0 ? (int) timeRemaining : 255);

            if (this.lerpingY.getCurrent() == -1.f) {
                this.lerpingY.setCurrent(ImGui.getIO().getDisplaySizeY() + 2.f);
            }

            this.setTarget(x, y);
            this.update();
            return this.notification.render(ImGui.getIO().getDisplaySizeX()
                    - Properties.Proportions.padding + this.lerpingX.getCurrent(), this.lerpingY.getCurrent(),
                    opacity);
        }
    }

    private static final List<NotificationRenderer> notificationQueue = new ArrayList<>();

    public static void onTick() {
        try {
            notificationQueue.removeIf(n -> n.timePassed(5000));
            float currentY = Properties.Proportions.padding;
            for (int x = 0; x < notificationQueue.size(); x++) {
                currentY += notificationQueue.get(x).render(0.f, currentY)
                        + Properties.Proportions.padding;
            }
        } catch (ConcurrentModificationException ignored) {}
    }

    public static void push(String title, String message) {
        notificationQueue.add(new NotificationRenderer(new Notification(title, message)));
    }

    public static void push(String iconUrl, String title, String message) {
        notificationQueue.add(new NotificationRenderer(new Notification(title, message).setIconUrl(iconUrl)));
    }
}
