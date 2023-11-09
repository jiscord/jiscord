package site.lifix.jiscord.ui;

import imgui.ImFont;
import imgui.ImFontConfig;
import imgui.ImFontGlyphRangesBuilder;
import imgui.ImGui;
import imgui.flag.ImGuiFreeTypeBuilderFlags;
import site.lifix.jiscord.utility.CallOnce;
import site.lifix.jiscord.utility.PermanentValue;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class Fonts {
    private static final PermanentValue<byte[]> productSansBoldData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansBoldItalicData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansItalicData = new PermanentValue<>();
    private static final PermanentValue<byte[]> productSansRegularData = new PermanentValue<>();
    private static final PermanentValue<byte[]> twemojiData = new PermanentValue<>();
    private static final CallOnce fontAllocationOnceFlag = new CallOnce();

    public static ImFont productSansRegular15px;
    public static ImFont productSansRegular20px;
    public static ImFont productSansRegular30px;
    public static ImFont productSansRegular40px;
    public static ImFont twemoji15px;
    public static ImFont twemoji20px;
    public static ImFont twemoji30px;
    public static ImFont twemoji40px;

    private static short[] getEmojiGlyphRanges() {
        int rangeStart = 0x1;
        int rangeEnd = 0x1FFFF;

        ImFontGlyphRangesBuilder builder = new ImFontGlyphRangesBuilder();
        for (int range = rangeStart; range < rangeEnd; range++) {
            builder.addChar((char) range);
        }

        return builder.buildRanges();
    }

    private static ImFontConfig createFontConfig(String name) {
        ImFontConfig config = new ImFontConfig();
        config.setFontDataOwnedByAtlas(false);
        config.setName(name);
        return config;
    }

    private static ImFontConfig createTwemojiConfig(String name, int size) {
        ImFontConfig config = new ImFontConfig();
        config.setOversampleH(1);
        config.setOversampleV(1);
        config.setMergeMode(true);
        config.setFontBuilderFlags(config.getFontBuilderFlags() | ImGuiFreeTypeBuilderFlags.LoadColor);
        config.setGlyphMinAdvanceX(size);
        config.setName(name + " " + size + "px");
        return config;
    }

    public static void onTick() {
        productSansBoldData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansBold.ttf"));
        productSansBoldItalicData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansBoldItalic.ttf"));
        productSansItalicData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansItalic.ttf"));
        productSansRegularData.set(() -> Utility.fileToByteArray("ui/fonts/ProductSansRegular.ttf"));
        twemojiData.set(() -> Utility.fileToByteArray("ui/fonts/Twemoji.ttf"));

        fontAllocationOnceFlag.exec(() -> {
            /*
            * You may ask; "why initialise 20px before 15???!?"
            * This is because ImGui initialises the first font added as the default font (used for windows, etc. if not
            *  manually set)
            * Because of this, and 15px being quite small, 20px is a sensible default value.
            * */
            productSansRegular20px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 20.f, createFontConfig("Product Sans Regular 20px"));
            twemoji20px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    twemojiData.get(), 20.f, createTwemojiConfig("Twemoji", 20));

            productSansRegular15px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 15.f, createFontConfig("Product Sans Regular 15px"));
//            twemoji15px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
//                    twemojiData.get(), 15.f, createTwemojiConfig("Twemoji", 15),
//                    getEmojiGlyphRanges());

            productSansRegular30px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 30.f, createFontConfig("Product Sans Regular 30px"));
//            twemoji30px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
//                    twemojiData.get(), 30.f, createTwemojiConfig("Twemoji", 30),
//                    getEmojiGlyphRanges());

            productSansRegular40px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
                    productSansRegularData.get(), 40.f, createFontConfig("Product Sans Regular 40px"));
//            twemoji40px = ImGui.getIO().getFonts().addFontFromMemoryTTF(
//                    twemojiData.get(), 40.f, createTwemojiConfig("Twemoji", 40),
//                    getEmojiGlyphRanges());
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
