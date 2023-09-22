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
import site.lifix.jiscord.ui.notifications.NotificationManager;
import site.lifix.jiscord.utility.Utility;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ServerListElement extends AbstractElement {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class ServerDisplayElement {
        private String url;
        private int id;
        private boolean loaded;
    }

    public static final List<GuildObject> partialGuilds = new ArrayList<>();
    public static final Map<String, ServerDisplayElement> guildIcons = new HashMap<>();
    private static final int guildIconSize = 52;
    private static final int guildIconGap = 8;

    private static final String guildIconUrl = "https://cdn.discordapp.com/icons/{guildId}/{icon}.{ext}?size={sz}";

    public void render(float left, float top, float right, float bottom, ImGuiIO io) {
        Renderer.BACKGROUND.rect(left, top, right, bottom, Properties.widgetBackgroundColour, 20.f);

        AtomicInteger currentY = new AtomicInteger((int) top + guildIconGap);
        List<GuildObject> safePartialGuilds = Arrays.asList(partialGuilds.toArray(new GuildObject[0]));
        safePartialGuilds.forEach((guild) -> {
            if (guild.getId().exists() && guild.getIcon().exists() && guild.getIcon().get() != null) {
                try {
                    String iconUrl = guildIconUrl.replace("{guildId}", guild.getId().get())
                            .replace("{icon}", guild.getIcon().get())
                            // gif loading non-existent rn
                            .replace("{ext}", guild.getIcon().get().startsWith("a_") ? "png" : "png")
                            .replace("{sz}", "256");

                    byte[] iconData = ImageCache.getImageData(iconUrl);
                    if (iconData.length != 0) {
                        if (!guildIcons.containsKey(iconUrl)) {
                            Images.ImageData data = Images.loadTexture(iconData, 256, 256);
                            guildIcons.put(iconUrl, new ServerDisplayElement(iconUrl, data.getTextureId(), true));
                        }

                        if (guildIcons.containsKey(iconUrl)) {
                            ImGui.getBackgroundDrawList().addImageRounded(guildIcons.get(iconUrl).getId(),
                                    left + (right - left) / 2 - 26, currentY.get(),
                                    left + (right - left) / 2 + 26, currentY.get() + 52,
                                    0, 0, 1, 1,
                                    ImColor.rgba(255, 255, 255, 255), 26);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ImGui.getBackgroundDrawList().addRectFilled(left + (right - left) / 2 - 26,
                        currentY.get(),
                        left + (right - left) / 2 + 26, currentY.get() + 52,
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

            currentY.addAndGet(guildIconSize + guildIconGap);
        });
    }
}

