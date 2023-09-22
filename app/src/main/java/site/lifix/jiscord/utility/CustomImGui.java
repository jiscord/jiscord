package site.lifix.jiscord.utility;

import imgui.ImGui;
import site.lifix.jiscord.ui.Fonts;

public class CustomImGui {
    public static void titledGroup(String title, Runnable groupInline) {
        Fonts.useFont(Fonts.productSansRegular30px, () -> ImGui.text(title));
        ImGui.separator();
        groupInline.run();
    }
}
