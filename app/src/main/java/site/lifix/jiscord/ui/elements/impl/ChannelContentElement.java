package site.lifix.jiscord.ui.elements.impl;

import imgui.ImColor;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.ImVec2;
import lombok.Setter;
import site.lifix.jiscord.api.objects.message.MessageObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.api.requests.Requests;
import site.lifix.jiscord.api.statics.cdn.CDNEndpoints;
import site.lifix.jiscord.api.statics.cdn.CDNFileFormat;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.AbstractElement;
import site.lifix.jiscord.ui.images.StaticTextures;
import site.lifix.jiscord.utility.SnowflakeList;
import site.lifix.jiscord.utility.Utility;
import site.lifix.jiscord.utility.ValidatedValue;

import java.awt.*;
import java.awt.event.ItemEvent;

public class ChannelContentElement extends AbstractElement {
    @Setter
    private boolean apiRequiresRefresh = true;

    private static final float messagePaddingHorizontal = 16f;
    private static final float messagePaddingNewGroup = 17f;
    private static final float messageAvatarSize = 40f;
    private static final float messageAvatarPadding = 4f;

    private static SnowflakeList<MessageObject> messages = new SnowflakeList<>();

    public void render(float left, float top, float right, float bottom, ImGuiIO io) {
        Renderer.BACKGROUND.rect(left, top, right, bottom, Properties.widgetBackgroundColour, 20.f);

        if (this.apiRequiresRefresh) {
            if (!ChannelListElement.selectedChannelId.isEmpty()) {
                new Thread(() -> {
                    messages = new SnowflakeList<MessageObject>()
                            .apply(Requests.getMessagesInChannel(ChannelListElement.selectedChannelId, 50),
                                    m -> Long.parseLong(m.getId().get("0")));
                }).start();
                this.apiRequiresRefresh = false;
            }
        }

        float baseY = 0f;
        for (MessageObject message : messages.getFromOldest()) {
            float iconLeft = left + messagePaddingHorizontal;
            float iconTop = top + baseY + messageAvatarPadding;
            float iconRight = iconLeft + messageAvatarSize;
            float iconBottom = iconTop + messageAvatarSize;

            float contentX = iconRight + messagePaddingHorizontal;
            float contentHorizontalPadding = contentX - left;
            float contentWrapWidth = Utility.positiveDiff(left, right) - (contentHorizontalPadding * 2f);

            String messageContent = message.getContent().get("");
            String messageAuthor = message.getAuthor().get().getGlobalName()
                    .get(message.getAuthor().get().getUsername().get());

            UserObject author = message.getAuthor().get();
            String userAvatar = CDNEndpoints.getDefaultUserAvatarUrl(author);
            if (author.getAvatar().existsNonNull()) {
                userAvatar = CDNEndpoints.getUserAvatarUrl(author.getId().get("0"),
                        author.getAvatar().get("0"), CDNFileFormat.PNG);
            }

            ValidatedValue<Integer> avatar = StaticTextures.getTexture(userAvatar,
                    128, 128);

            if (avatar.valid()) {
                ImGui.getBackgroundDrawList().addImageRounded(avatar.get(),
                        iconLeft, iconTop, iconRight, iconBottom,
                        0, 0, 1, 1,
                        Color.WHITE.getRGB(), messageAvatarSize / 2f);
            } else {
                ImGui.getBackgroundDrawList().addRectFilled(iconLeft, iconTop,
                        iconRight, iconBottom, ImColor.rgba(49, 50, 51, 255),
                        messageAvatarSize / 2f);
            }

            Renderer.BACKGROUND.text(Fonts.productSansRegular20px, messageAuthor,
                    contentX, top + baseY, Color.WHITE, contentWrapWidth);
            Renderer.BACKGROUND.text(Fonts.productSansRegular20px, messageContent,
                    contentX, top + baseY + Fonts.productSansRegular20px.getFontSize() + 2f,
                    Color.WHITE, contentWrapWidth);

            float size = messageAvatarPadding * 2f + messageAvatarSize;
            ImVec2 textSize = new ImVec2();
            Fonts.useFont(Fonts.productSansRegular20px, () -> {
                ImVec2 calculated = ImGui.calcTextSize(messageContent, false, contentWrapWidth);
                textSize.x = calculated.x;
                textSize.y = Fonts.productSansRegular20px.getFontSize() + 2f + calculated.y;
            });
            size = Math.max(size, textSize.y);
            baseY += size + messagePaddingNewGroup;
        }
    }
}
