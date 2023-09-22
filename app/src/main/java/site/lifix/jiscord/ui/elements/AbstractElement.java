package site.lifix.jiscord.ui.elements;

import imgui.ImGuiIO;

public abstract class AbstractElement {
    public abstract void render(float left, float top, float right, float bottom, ImGuiIO io);
}
