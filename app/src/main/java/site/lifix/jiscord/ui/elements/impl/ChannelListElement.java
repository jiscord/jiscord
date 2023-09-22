package site.lifix.jiscord.ui.elements.impl;

import imgui.ImGuiIO;
import site.lifix.jiscord.ui.Properties;
import site.lifix.jiscord.ui.Renderer;
import site.lifix.jiscord.ui.elements.AbstractElement;

public class ChannelListElement extends AbstractElement {
    public void render(float left, float top, float right, float bottom, ImGuiIO io) {
        Renderer.BACKGROUND.rect(left, top, right, bottom, Properties.widgetBackgroundColour, 20.f);
    }
}
