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
import site.lifix.jiscord.api.util.Snowflake;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.AbstractElement;
import site.lifix.jiscord.ui.images.StaticTextures;
import site.lifix.jiscord.ui.utility.LerpingFloat;
import site.lifix.jiscord.utility.SnowflakeList;
import site.lifix.jiscord.utility.Utility;
import site.lifix.jiscord.utility.ValidatedValue;

import java.awt.*;

public class ChannelContentElement extends AbstractElement {
    @Setter
    private boolean apiRequiresRefresh = true;

    private float totalHeight = 0f;

    private static final float messagePaddingHorizontal = 16f;
    private static final float messagePaddingNewGroup = 17f;
    private static final float messageAvatarSize = 40f;
    private static final float messageAvatarPadding = 4f;

    private static SnowflakeList<MessageObject> messages = new SnowflakeList<>();

    private static final LerpingFloat smoothScroller = new LerpingFloat(0.f, 0.1414f);

    private float renderMessages(float left, float top, float right, boolean onlyCalculate) {
        Snowflake lastMessage = Snowflake.from(0L);
        Snowflake lastMessageAuthor = Snowflake.from(0L);

        float baseY = 0f;
        for (MessageObject message : messages.getFromOldest()) {
            Snowflake currentMessage = Snowflake.from(message.getId());
            Snowflake currentMessageAuthor = Snowflake.from(message.getAuthor().get().getId());

            boolean sameGroup = currentMessageAuthor.equals(lastMessageAuthor)
                    && Utility.positiveDiff(currentMessage.getTimestamp(), lastMessage.getTimestamp()) < 5 * 60 * 1000;

            if (!sameGroup) {
                baseY += messagePaddingNewGroup;
            }

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

            if (!sameGroup && !onlyCalculate) {
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
            }

            if (!onlyCalculate) {
                Renderer.BACKGROUND.text(Fonts.productSansRegular20px, messageContent,
                        contentX, top + baseY + (sameGroup ? 0f : Fonts.productSansRegular20px.getFontSize()) + 2f,
                        Color.WHITE, contentWrapWidth);
            }

            float size = messageAvatarPadding * 2f + messageAvatarSize;
            if (sameGroup) {
                size = 0f;
            }
            ImVec2 textSize = new ImVec2();
            Fonts.useFont(Fonts.productSansRegular20px, () -> {
                if (!messageContent.isEmpty()) {
                    ImVec2 calculated = ImGui.calcTextSize(messageContent, false,
                            contentWrapWidth);
                    textSize.x = calculated.x;
                    if (sameGroup) {
                        textSize.y = 4f + calculated.y;
                    } else {
                        textSize.y = Fonts.productSansRegular20px.getFontSize() + 2f + calculated.y;
                    }
                }
            });

            lastMessage = currentMessage;
            lastMessageAuthor = currentMessageAuthor;

            size = Math.max(size, textSize.y);
            baseY += size;
        }

        return baseY;
    }

    public void render(float left, float topIn, float right, float bottom, ImGuiIO io) {
        Renderer.BACKGROUND.rect(left, topIn, right, bottom, Properties.widgetBackgroundColour, 20.f);
        smoothScroller.update();

        float top = topIn + smoothScroller.getCurrent() + 8f;

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

        float listHeight = Utility.positiveDiff(topIn, bottom);
        this.totalHeight = this.renderMessages(left, top, right, true);
        this.renderMessages(left, top + listHeight - this.totalHeight - 92f, right, false);

        if (this.totalHeight != 0f) {
            if (smoothScroller.getTarget() < 0f) {
                smoothScroller.setTarget(0f);
            }

            if (this.totalHeight > listHeight) {
                //if (this.totalHeight + smoothScroller.getTarget() > listHeight + 2f) {
                //    smoothScroller.setTarget(listHeight - this.totalHeight - 4f);
                //}
            }
        }
    }

    public void onScroll(float left, float top, float right, float bottom, float amount) {
        if (this.totalHeight > Utility.positiveDiff(top, bottom)) {
            smoothScroller.setTarget(smoothScroller.getTarget()
                    + (amount * 80f));
        } else {
            smoothScroller.setTarget(0f);
        }
    }
}
