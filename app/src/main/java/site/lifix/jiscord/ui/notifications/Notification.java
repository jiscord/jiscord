package site.lifix.jiscord.ui.notifications;

import imgui.ImGui;
import imgui.ImVec2;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.utility.Utility;

import java.util.concurrent.atomic.AtomicReference;

public class Notification {
    private final String title;
    private final String message;

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public float render(float x, float y, int opacity) {
        float notificationRounding = 10.f;
        float notificationMaxWidth = 300.f;

        AtomicReference<ImVec2> contentTextSize = new AtomicReference<>();
        Fonts.useFont(Fonts.productSansRegular20px, () ->
                contentTextSize.set(ImGui.calcTextSize(this.message, false, notificationMaxWidth)));

        Renderer.FOREGROUND.rect(Renderer.RenderAnchor.TOP_RIGHT, x, y,
                x + notificationMaxWidth + notificationRounding * 2.f,
                y + Fonts.productSansRegular30px.getFontSize()
                        + contentTextSize.get().y + notificationRounding * 3,
                Utility.applyOpacity(Properties.widgetBackgroundColourHovered, opacity),
                notificationRounding);

        Renderer.FOREGROUND.rectHollow(Renderer.RenderAnchor.TOP_RIGHT, x, y,
                x + notificationMaxWidth + notificationRounding * 2.f,
                y + Fonts.productSansRegular30px.getFontSize()
                        + contentTextSize.get().y + notificationRounding * 3,
                Utility.applyOpacity(Properties.widgetAccentBackgroundColour, opacity),
                notificationRounding);

        Renderer.FOREGROUND.text(Fonts.productSansRegular30px, this.title,
                x - notificationMaxWidth - notificationRounding,
                y + notificationRounding,
                Utility.applyOpacity(Properties.primaryForegroundColour, opacity));

        Renderer.FOREGROUND.text(Fonts.productSansRegular20px, this.message,
                x - notificationMaxWidth - notificationRounding,
                y + notificationRounding * 2 + Fonts.productSansRegular30px.getFontSize(),
                Utility.applyOpacity(Properties.primaryForegroundColour, opacity), notificationMaxWidth);

        return Fonts.productSansRegular30px.getFontSize() + contentTextSize.get().y + notificationRounding * 3;
    }
}
