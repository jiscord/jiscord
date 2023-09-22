package site.lifix.jiscord.ui;

import imgui.ImFont;
import imgui.ImFontConfig;
import imgui.ImGui;
import site.lifix.jiscord.utility.CallOnce;
import site.lifix.jiscord.utility.PermanentValue;
import site.lifix.jiscord.utility.Utility;

public class Fonts {
    private static final PermanentValue<byte[]> productSansBoldData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansBoldItalicData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansItalicData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansRegularData = new PermanentValue<>();
    private static final CallOnce fontAllocationOnceFlag = new CallOnce();

    public static ImFont productSansRegular15px;
    public static ImFont productSansRegular20px;
    public static ImFont productSansRegular30px;
    public static ImFont productSansRegular40px;

    private static ImFontConfig createFontConfig(String name) {
        ImFontConfig config = new ImFontConfig();
        config.setFontDataOwnedByAtlas(false);
        config.setName(name);
        return config;
    }

    public static void onTick() {
        productSansBoldData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansBold.ttf"));
        productSansBoldItalicData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansBoldItalic.ttf"));
        productSansItalicData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansItalic.ttf"));
        productSansRegularData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansRegular.ttf"));

        fontAllocationOnceFlag.exec(() -> {
            /*
            * You may ask; "why initialise 20px before 15???!?"
            * This is because ImGui initialises the first font added as the default font (used for windows, etc. if not
            *  manually set)
            * Because of this, and 15px being quite small, 20px is a sensible default value.
            * */
            productSansRegular20px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 20.f, createFontConfig("Product Sans Regular 20px"));

            productSansRegular15px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 15.f, createFontConfig("Product Sans Regular 15px"));
            productSansRegular30px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 30.f, createFontConfig("Product Sans Regular 30px"));
            productSansRegular40px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 40.f, createFontConfig("Product Sans Regular 40px"));
        });
    }

    public static void useFont(ImFont font, Runnable runnable) {
        if (font != null) {
            ImGui.pushFont(font);
        }
        runnable.run();
        if (font != null) {
            ImGui.popFont();
        }
    }
}
