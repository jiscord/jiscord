package site.lifix.jiscord.ui.elements;

import imgui.ImGui;
import imgui.ImGuiIO;
import site.lifix.jiscord.ui.Renderer;

public abstract class AbstractElement {
    public abstract void render(float left, float top, float right, float bottom, ImGuiIO io);
    public void onScroll(float left, float top, float right, float bottom, float amount) {}

    public void process(float left, float top, float right, float bottom) {
        Renderer.BACKGROUND.scissor(left, top, right, bottom, () ->
                this.render(left, top, right, bottom, ImGui.getIO()));
        this.onScroll(left, top, right, bottom, ImGui.getIO().getMouseWheel());
    }
}
