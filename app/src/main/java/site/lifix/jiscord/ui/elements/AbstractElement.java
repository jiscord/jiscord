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

        float mouseX = ImGui.getIO().getMousePosX();
        float mouseY = ImGui.getIO().getMousePosY();
        if (mouseX >= left && mouseX <= right && mouseY >= top && mouseY <= bottom) {
            this.onScroll(left, top, right, bottom, ImGui.getIO().getMouseWheel());
        }
    }
}
