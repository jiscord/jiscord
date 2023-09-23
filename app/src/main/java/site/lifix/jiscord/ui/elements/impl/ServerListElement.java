package site.lifix.jiscord.ui.elements.impl;

import imgui.ImColor;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImVec2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.lifix.jiscord.api.objects.guild.GuildObject;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.AbstractElement;
import site.lifix.jiscord.ui.images.ImageCache;
import site.lifix.jiscord.ui.images.Images;
import site.lifix.jiscord.ui.images.StaticTextures;
import site.lifix.jiscord.ui.notifications.NotificationManager;
import site.lifix.jiscord.ui.utility.LerpingFloat;
import site.lifix.jiscord.utility.Utility;
import site.lifix.jiscord.utility.ValidatedValue;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ServerListElement extends AbstractElement {
    public static final List<GuildObject> partialGuilds = new ArrayList<>();
    private static final int guildIconSize = 52;
    private static final int guildIconGap = 8;

    private static final String guildIconUrl = "https://cdn.discordapp.com/icons/{guildId}/{icon}.{ext}?size={sz}";

    private static final LerpingFloat smoothScroller = new LerpingFloat(0.f, 0.1414f);

    public void render(float left, float top, float right, float bottom, ImGuiIO io) {
        Renderer.BACKGROUND.rect(left, top, right, bottom, Properties.widgetBackgroundColour, 20.f);

        AtomicInteger currentY = new AtomicInteger((int) (top + guildIconGap + smoothScroller.getCurrent()));
        List<GuildObject> safePartialGuilds = Arrays.asList(partialGuilds.toArray(new GuildObject[0]));

        float guildsTotalHeight = Math.max((guildIconSize * safePartialGuilds.size())
                + (guildIconGap * (safePartialGuilds.size() - 1)), 0f);
        smoothScroller.update();

        safePartialGuilds.forEach((guild) -> {
            float iconMinX = left + (right - left) / 2 - 26;
            float iconMinY = currentY.get();
            float iconMaxX = left + (right - left) / 2 + 26;
            float iconMaxY = currentY.get() + 52;

            if (guild.getId().exists() && guild.getIcon().exists() && guild.getIcon().get() != null) {
                try {
                    String iconUrl = guildIconUrl.replace("{guildId}", guild.getId().get())
                            .replace("{icon}", guild.getIcon().get())
                            // gif loading non-existent rn
                            .replace("{ext}", guild.getIcon().get().startsWith("a_") ? "png" : "png")
                            .replace("{sz}", "256");

                    ValidatedValue<Integer> icon = StaticTextures.getTexture(iconUrl, 256, 256);

                    if (icon.valid()) {
                        ImGui.getBackgroundDrawList().addImageRounded(icon.get(),
                                iconMinX, iconMinY, iconMaxX, iconMaxY,
                                0, 0, 1, 1,
                                ImColor.rgba(255, 255, 255, 255), 26);
                    } else {
                        ImGui.getBackgroundDrawList().addRectFilled(
                                iconMinX, iconMinY, iconMaxX, iconMaxY,
                                ImColor.rgba(49, 50, 51, 255), 26);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ImGui.getBackgroundDrawList().addRectFilled(
                        iconMinX, iconMinY, iconMaxX, iconMaxY,
                        ImColor.rgba(49, 50, 51, 255), 26);

                String abbreviated = String.join("", Utility.copyModified(guild.getName().get()
                        .split(" "), (original) -> original.isEmpty() ? "" : original.substring(0, 1)));

                AtomicReference<ImVec2> size = new AtomicReference<>(new ImVec2(0, 0));
                Fonts.useFont(Fonts.productSansRegular15px, () -> size.set(ImGui.calcTextSize(abbreviated)));

                Renderer.BACKGROUND.text(Fonts.productSansRegular15px, abbreviated,
                        left + (right - left) / 2 - size.get().x / 2,
                        currentY.get() + 26 - size.get().y / 2,
                        new Color(255, 255, 255, 255));
            }

            float mouseX = io.getMousePosX();
            float mouseY = io.getMousePosY();

            if (mouseX >= iconMinX && mouseX <= iconMaxX && mouseY >= iconMinY && mouseY <= iconMaxY) {
                ImGui.setTooltip(guild.getName().get("Unknown"));
            }

            currentY.addAndGet(guildIconSize + guildIconGap);
        });

        float elemHeight = Utility.positiveDiff(top, bottom);
        if (guildsTotalHeight != 0) {
            if (smoothScroller.getTarget() > 0f) {
                smoothScroller.setTarget(0f);
            }

            if (guildsTotalHeight > elemHeight) {
                if (guildsTotalHeight + smoothScroller.getTarget() < elemHeight + guildIconGap) {
                    smoothScroller.setTarget(elemHeight - guildsTotalHeight - (guildIconGap * 2));
                }
            }
        }
    }

    public void onScroll(float left, float top, float right, float bottom, float amount) {
        List<GuildObject> safePartialGuilds = Arrays.asList(partialGuilds.toArray(new GuildObject[0]));

        float guildsTotalHeight = (guildIconSize * safePartialGuilds.size())
                + (guildIconGap * (safePartialGuilds.size() - 1));

        if (guildsTotalHeight > Utility.positiveDiff(top, bottom)) {
            smoothScroller.setTarget(smoothScroller.getTarget() + (amount * (guildIconSize + guildIconGap)));
        } else {
            smoothScroller.setTarget(0f);
        }
    }
}

