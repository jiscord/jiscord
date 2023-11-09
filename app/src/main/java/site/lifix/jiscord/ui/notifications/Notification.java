package site.lifix.jiscord.ui.notifications;

import imgui.ImColor;
import imgui.ImGui;
import imgui.ImVec2;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.images.StaticTextures;
import site.lifix.jiscord.utility.Utility;
import site.lifix.jiscord.utility.ValidatedValue;

import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class Notification {
    private final String title;
    private final String message;
    private String iconUrl = "";
    private String attachmentUrl = "";

    public Notification(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Notification setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public Notification setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
        return this;
    }

    public float render(float x, float y, int opacity) {
        float notificationRounding = 10.f;
        AtomicReference<Float> notificationMaxWidth = new AtomicReference<>(300.f);
        ValidatedValue<StaticTextures.TextureData> attachment = new ValidatedValue<StaticTextures.TextureData>() {
            public StaticTextures.TextureData get() {
                return new StaticTextures.TextureData("", -1, false, -1, -1);
            }

            public boolean valid() {
                return false;
            }
        };

        if (!this.iconUrl.isEmpty()) {
            notificationMaxWidth.set(notificationMaxWidth.get() + 30f + notificationRounding);
        }

        if (!this.attachmentUrl.isEmpty()) {
            attachment = StaticTextures.getTextureData(this.attachmentUrl,
                    128, 128);
        }

        AtomicReference<ImVec2> contentTextSize = new AtomicReference<>();

        Fonts.useFont(Fonts.productSansRegular30px, () -> {
            ImVec2 titleSize = ImGui.calcTextSize(this.title, false);
            if (this.iconUrl.isEmpty()) {
                notificationMaxWidth.set(Math.max(titleSize.x, notificationMaxWidth.get()));
            } else {
                notificationMaxWidth.set(Math.max(titleSize.x + 30f + notificationRounding,
                        notificationMaxWidth.get()));
            }
        });

        Fonts.useFont(Fonts.productSansRegular20px, () ->
                contentTextSize.set(ImGui.calcTextSize(this.message, false,
                        notificationMaxWidth.get() - (this.iconUrl.isEmpty() ? 0f
                                : notificationRounding + 30f))));

        float rectMaxX = x + notificationMaxWidth.get() + notificationRounding * 2.f;
        float rectMaxY = y + Fonts.productSansRegular30px.getFontSize() + contentTextSize.get().y
                + notificationRounding * 3;

        float attachmentMinY = rectMaxY;

        float attachmentVisualWidth = 0f;
        float attachmentVisualHeight = 0f;

        if (!this.attachmentUrl.isEmpty()) {
            if (attachment.valid()) {
                float rectWidth = notificationMaxWidth.get();

                float attachmentWidth = attachment.get().getWidth();
                float attachmentHeight = attachment.get().getHeight();

                attachmentVisualWidth = rectWidth - notificationRounding * 2.f;
                attachmentVisualHeight = (attachmentVisualWidth / attachmentWidth) * attachmentHeight;

                rectMaxY += notificationRounding;
                rectMaxY += attachmentVisualHeight;
            }
        }

        Renderer.FOREGROUND.rect(Renderer.RenderAnchor.TOP_RIGHT,
                x, y, rectMaxX, rectMaxY,
                Utility.applyOpacity(Properties.widgetBackgroundColourHovered, opacity),
                notificationRounding);

        Renderer.FOREGROUND.rectHollow(Renderer.RenderAnchor.TOP_RIGHT,
                x, y, rectMaxX, rectMaxY,
                Utility.applyOpacity(Properties.widgetAccentBackgroundColour, opacity),
                notificationRounding);

        Renderer.FOREGROUND.text(Fonts.productSansRegular30px, this.title,
                x - notificationMaxWidth.get() - notificationRounding + (this.iconUrl.isEmpty() ? 0f
                        : notificationRounding + 30f),
                y + notificationRounding,
                Utility.applyOpacity(Properties.primaryForegroundColour, opacity));

        Renderer.FOREGROUND.text(Fonts.productSansRegular20px, this.message,
                x - notificationMaxWidth.get() - notificationRounding + (this.iconUrl.isEmpty() ? 0f
                        : notificationRounding + 30f),
                y + notificationRounding * 2 + Fonts.productSansRegular30px.getFontSize(),
                Utility.applyOpacity(Properties.primaryForegroundColour, opacity),
                notificationMaxWidth.get() - (this.iconUrl.isEmpty() ? 0f
                        : notificationRounding + 30f));

        if (!this.iconUrl.isEmpty()) {
            ValidatedValue<Integer> icon = StaticTextures.getTexture(this.iconUrl, 128, 128);

            if (icon.valid()) {
                ImGui.getForegroundDrawList().addImageRounded(icon.get(),
                        x - notificationMaxWidth.get() - notificationRounding,
                        y + notificationRounding,
                        x - notificationMaxWidth.get() - notificationRounding + 30f,
                        y + notificationRounding + 30f,
                        0, 0, 1, 1,
                        ImColor.rgba(255, 255, 255, opacity), 15f);
            } else {
                ImGui.getForegroundDrawList().addRectFilled(
                        x - notificationMaxWidth.get() - notificationRounding,
                        y + notificationRounding,
                        x - notificationMaxWidth.get() - notificationRounding + 30f,
                        y + notificationRounding + 30f,
                        ImColor.rgba(49, 50, 51, opacity), 15f);
            }
        }

        if (!this.attachmentUrl.isEmpty()) {
            if (attachment.valid()) {
                ImGui.getForegroundDrawList().addImageRounded(attachment.get().getId(),
                        x - notificationMaxWidth.get() - notificationRounding, attachmentMinY,
                        x - notificationMaxWidth.get() - notificationRounding + attachmentVisualWidth,
                        attachmentMinY + attachmentVisualHeight,
                        0, 0, 1, 1,
                        ImColor.rgba(255, 255, 255, opacity), 15f);
            }
        }

        return Fonts.productSansRegular30px.getFontSize() + contentTextSize.get().y + notificationRounding * 3
                + attachmentVisualHeight + (attachment.valid() ? notificationRounding : 0f);
    }
}
