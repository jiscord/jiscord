package site.lifix.jiscord.ui.elements.impl;

import imgui.ImColor;
import imgui.ImGui;
import imgui.ImGuiIO;
import lombok.Setter;
import site.lifix.jiscord.Main;
import site.lifix.jiscord.api.SocketClient;
import site.lifix.jiscord.api.objects.channel.ChannelObject;
import site.lifix.jiscord.api.objects.user.UserObject;
import site.lifix.jiscord.api.requests.Requests;
import site.lifix.jiscord.api.statics.cdn.CDNEndpoints;
import site.lifix.jiscord.api.statics.cdn.CDNFileFormat;
import site.lifix.jiscord.api.statics.channel.ChannelType;
import site.lifix.jiscord.ui.Fonts;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.AbstractElement;
import site.lifix.jiscord.ui.images.StaticTextures;
import site.lifix.jiscord.ui.utility.LerpingFloat;
import site.lifix.jiscord.utility.Utility;
import site.lifix.jiscord.utility.ValidatedValue;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ChannelListElement extends AbstractElement {
    @Setter
    private boolean apiRequiresRefresh = true;
    private List<ChannelObject> channelList = new ArrayList<>();

    private static final float privateElemHeight = 42f;
    private static final float privateElemPaddingHorizontal = 8f;
    private static final float privateElemPaddingVertical = 2f;
    private static final float privateElemIconSize = 32f;

    private static final LerpingFloat smoothScroller = new LerpingFloat(0.f, 0.1414f);

    public static String selectedChannelId = "";

    public void render(float left, float topIn, float right, float bottom, ImGuiIO io) {
        float listWidth = Utility.positiveDiff(right, left);
        float listHeight = Utility.positiveDiff(bottom, topIn);
        float channelsTotalHeight = 0f;

        Renderer.BACKGROUND.rect(left, topIn, right, bottom, Properties.widgetBackgroundColour, 20.f);
        smoothScroller.update();

        float top = topIn + smoothScroller.getCurrent() + 8f;

        if (!GuildListElement.selectedGuildId.isEmpty()
                && GuildListElement.partialGuilds.containsKey(GuildListElement.selectedGuildId)) {
            if (this.apiRequiresRefresh) {
                this.channelList = new ArrayList<>();
                this.apiRequiresRefresh = false;
            }
            // TODO: Render server name, banner and channels
        } else {
            GuildListElement.selectedGuildId = "";
            channelsTotalHeight = Math.max((privateElemHeight + privateElemPaddingVertical) * this.channelList.size(),
                    0f);

            if (SocketClient.instance != null && !SocketClient.instance.getToken().isEmpty()) {
                if (this.apiRequiresRefresh) {
                    this.channelList.clear();
                    this.channelList.addAll(Requests.getPrivateChannels());
                    this.apiRequiresRefresh = false;
                }

                float mouseX = io.getMousePosX();
                float mouseY = io.getMousePosY();

                float baseY = 0f;
                for (ChannelObject channel : this.channelList) {
                    float elemLeft = left + privateElemPaddingHorizontal;
                    float elemTop = top + baseY;
                    float elemRight = left + listWidth - privateElemPaddingHorizontal;
                    float elemBottom = elemTop + privateElemHeight;

                    float iconLeft = elemLeft + 8f;
                    float iconTop = elemTop + (privateElemHeight / 2f) - (privateElemIconSize / 2f);
                    float iconRight = elemLeft + 8f + privateElemIconSize;
                    float iconBottom = elemTop + (privateElemHeight / 2f) + (privateElemIconSize / 2f);

                    float textX = iconRight + 12f;
                    float textY = elemTop + (privateElemHeight / 2f)
                            - (Fonts.productSansRegular20px.getFontSize() / 2f);

                    if (mouseX >= elemLeft && mouseX <= elemRight && mouseY >= elemTop && mouseY <= elemBottom) {
                        Renderer.BACKGROUND.rect(elemLeft, elemTop, elemRight, elemBottom,
                                new Color(49, 50, 51, 255), 3f);

                        if (ImGui.isMouseClicked(0)) {
                            selectedChannelId = channel.getId().get("");
                            Main.channelContentElement.setApiRequiresRefresh(true);
                        }
                    }

                    switch (channel.getType().get(0)) {
                        // A private channel between two users
                        case ChannelType.DM:
                            UserObject recipient = channel.getRecipients().get(0);
                            String userAvatar = CDNEndpoints.getDefaultUserAvatarUrl(recipient);
                            if (recipient.getAvatar().existsNonNull()) {
                                userAvatar = CDNEndpoints.getUserAvatarUrl(recipient.getId().get("0"),
                                        recipient.getAvatar().get("0"), CDNFileFormat.PNG);
                            }

                            ValidatedValue<Integer> avatar = StaticTextures.getTexture(userAvatar,
                                    128, 128);

                            if (avatar.valid()) {
                                ImGui.getBackgroundDrawList().addImageRounded(avatar.get(),
                                        iconLeft, iconTop, iconRight, iconBottom,
                                        0, 0, 1, 1,
                                        Color.WHITE.getRGB(), privateElemIconSize / 2f);
                            } else {
                                ImGui.getBackgroundDrawList().addRectFilled(iconLeft, iconTop,
                                        iconRight, iconBottom, ImColor.rgba(49, 50, 51, 255),
                                        privateElemIconSize / 2f);
                            }

                            Renderer.BACKGROUND.text(Fonts.productSansRegular20px,
                                    recipient.getGlobalName().get(recipient.getUsername().get("null")),
                                    textX, textY, Color.WHITE);
                            break;

                        // A private channel between multiple users
                        case ChannelType.GROUP_DM:
                            String groupIcon = "";
                            if (channel.getIcon().existsNonNull()) {
                                groupIcon = CDNEndpoints.getChannelIconUrl(channel.getId().get("0"),
                                        channel.getIcon().get("0"), CDNFileFormat.PNG);
                            }

                            ValidatedValue<Integer> icon = StaticTextures.getTexture(groupIcon,
                                    128, 128);

                            if (icon.valid()) {
                                ImGui.getBackgroundDrawList().addImageRounded(icon.get(),
                                        iconLeft, iconTop, iconRight, iconBottom,
                                        0, 0, 1, 1,
                                        Color.WHITE.getRGB(), privateElemIconSize / 2f);
                            } else {
                                ImGui.getBackgroundDrawList().addRectFilled(iconLeft, iconTop,
                                        iconRight, iconBottom, ImColor.rgba(49, 50, 51, 255),
                                        privateElemIconSize / 2f);
                            }
                            Renderer.BACKGROUND.text(Fonts.productSansRegular20px, channel.getName().get("null"),
                                    textX, textY, Color.WHITE);
                            break;
                    }
                    baseY += privateElemHeight + privateElemPaddingVertical;
                }
            }
        }

        if (channelsTotalHeight != 0f) {
            if (smoothScroller.getTarget() > 0f) {
                smoothScroller.setTarget(0f);
            }

            if (channelsTotalHeight > listHeight) {
                if (channelsTotalHeight + smoothScroller.getTarget() < listHeight + 2f) {
                    smoothScroller.setTarget(listHeight - channelsTotalHeight - 4f);
                }
            }
        }
    }

    public void onScroll(float left, float top, float right, float bottom, float amount) {
        float channelsTotalHeight = (privateElemHeight * this.channelList.size())
                + (privateElemPaddingVertical * (this.channelList.size() - 1));

        if (channelsTotalHeight > Utility.positiveDiff(top, bottom)) {
            smoothScroller.setTarget(smoothScroller.getTarget()
                    + (amount * (privateElemHeight + privateElemPaddingVertical)));
        } else {
            smoothScroller.setTarget(0f);
        }
    }
}
