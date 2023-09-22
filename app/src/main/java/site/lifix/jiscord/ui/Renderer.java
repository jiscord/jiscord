package site.lifix.jiscord.ui;

import imgui.ImColor;
import imgui.ImDrawList;
import imgui.ImFont;
import imgui.ImGui;
import site.lifix.jiscord.utility.Utility;
import java.awt.Color;

public class Renderer {
    public static final Renderer BACKGROUND = new Renderer(RenderType.BACKGROUND);
    public static final Renderer FOREGROUND = new Renderer(RenderType.FOREGROUND);

    private final RenderType type;

    private Renderer(RenderType type) {
        this.type = type;
    }

    public ImDrawList drawList() {
        switch (this.type) {
            case BACKGROUND:
                return ImGui.getBackgroundDrawList();
            case FOREGROUND:
                return ImGui.getForegroundDrawList();
        }

        return null;
    }

    public int imColorFromAwt(Color color) {
        return ImColor.rgba(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public void rect(float leftIn, float topIn, float rightIn, float bottomIn, Color color) {
        this.rect(leftIn, topIn, rightIn, bottomIn, color, 0.f);
    }

    public void rect(float leftIn, float topIn, float rightIn, float bottomIn, Color color, float rounding) {
        this.rect(RenderAnchor.TOP_LEFT, leftIn, topIn, rightIn, bottomIn, color, rounding);
    }

    public void rect(RenderAnchor anchor, float leftIn, float topIn, float rightIn, float bottomIn, Color color) {
        this.rect(anchor, leftIn, topIn, rightIn, bottomIn, color, 0.f);
    }

    public void rect(RenderAnchor anchor, float leftIn, float topIn, float rightIn, float bottomIn, Color color,
                     float rounding) {
        float left = leftIn;
        float top = topIn;
        float right = rightIn;
        float bottom = bottomIn;

        float width = Math.max(left, right) - Math.min(left, right);
        float height = Math.max(top, bottom) - Math.min(top, bottom);

        if (Utility.is(anchor, RenderAnchor.TOP, RenderAnchor.CENTER, RenderAnchor.BOTTOM)) {
            left -= width / 2.f;
            right -= width / 2.f;
        } else if (Utility.is(anchor, RenderAnchor.TOP_RIGHT, RenderAnchor.RIGHT, RenderAnchor.BOTTOM_RIGHT)) {
            left -= width;
            right -= width;
        }

        if (Utility.is(anchor, RenderAnchor.LEFT, RenderAnchor.CENTER, RenderAnchor.RIGHT)) {
            top -= height / 2.f;
            bottom -= height / 2.f;
        } else if (Utility.is(anchor, RenderAnchor.BOTTOM_LEFT, RenderAnchor.BOTTOM, RenderAnchor.BOTTOM_RIGHT)) {
            top -= height;
            bottom -= height;
        }

        this.drawList().addRectFilled(left, top, right, bottom, imColorFromAwt(color), rounding);
    }

    public void rectHollow(float leftIn, float topIn, float rightIn, float bottomIn, Color color) {
        this.rectHollow(leftIn, topIn, rightIn, bottomIn, color, 0.f);
    }

    public void rectHollow(float leftIn, float topIn, float rightIn, float bottomIn, Color color, float rounding) {
        this.rectHollow(RenderAnchor.TOP_LEFT, leftIn, topIn, rightIn, bottomIn, color, rounding);
    }

    public void rectHollow(RenderAnchor anchor, float leftIn, float topIn, float rightIn, float bottomIn, Color color) {
        this.rectHollow(anchor, leftIn, topIn, rightIn, bottomIn, color, 0.f);
    }

    public void rectHollow(RenderAnchor anchor, float leftIn, float topIn, float rightIn, float bottomIn, Color color,
                     float rounding) {
        float left = leftIn;
        float top = topIn;
        float right = rightIn;
        float bottom = bottomIn;

        float width = Math.max(left, right) - Math.min(left, right);
        float height = Math.max(top, bottom) - Math.min(top, bottom);

        if (Utility.is(anchor, RenderAnchor.TOP, RenderAnchor.CENTER, RenderAnchor.BOTTOM)) {
            left -= width / 2.f;
            right -= width / 2.f;
        } else if (Utility.is(anchor, RenderAnchor.TOP_RIGHT, RenderAnchor.RIGHT, RenderAnchor.BOTTOM_RIGHT)) {
            left -= width;
            right -= width;
        }

        if (Utility.is(anchor, RenderAnchor.LEFT, RenderAnchor.CENTER, RenderAnchor.RIGHT)) {
            top -= height / 2.f;
            bottom -= height / 2.f;
        } else if (Utility.is(anchor, RenderAnchor.BOTTOM_LEFT, RenderAnchor.BOTTOM, RenderAnchor.BOTTOM_RIGHT)) {
            top -= height;
            bottom -= height;
        }

        this.drawList().addRect(left, top, right, bottom, imColorFromAwt(color), rounding);
    }

    public void text(ImFont font, String text, float posX, float posY, Color color) {
        this.drawList().addText(font, font.getFontSize(), posX, posY, imColorFromAwt(color), text);
    }

    public void text(ImFont font, String text, float posX, float posY, Color color, float wrapWidth) {
        this.drawList().addText(font, font.getFontSize(), posX, posY, imColorFromAwt(color), text, wrapWidth);
    }

    public enum RenderType {
        FOREGROUND,
        BACKGROUND
    }


    public enum RenderAnchor {
        TOP_LEFT, TOP, TOP_RIGHT,
        LEFT, CENTER, RIGHT,
        BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT
    }
}
