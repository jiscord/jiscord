package site.lifix.jiscord.ui;

import imgui.ImColor;

import java.awt.Color;

public class Properties {
    public static final Color white = new Color(255, 255, 255, 255);

    public static final Color backgroundColour = new Color(25, 28, 30, 255);
    public static final Color widgetBackgroundColour = new Color(29, 35, 39, 255);
    public static final Color widgetBackgroundColourHovered = new Color(60, 66, 70, 255);

    public static final Color primaryForegroundColour = new Color(230, 230, 230, 255);
    public static final Color secondaryForegroundColour = new Color(200, 200, 200, 255);

    public static final Color foregroundSeparatorColour = new Color(47, 47, 47, 255);

    public static final Color widgetAccentBackgroundColour = new Color(118, 209, 255, 255);
    public static final Color widgetAccentBackgroundColourHovered = new Color(93, 172, 214, 255);
    public static final Color widgetAccentForegroundColour = new Color(0, 53, 73, 255);
    public static final Color widgetAccentForegroundColourHovered = new Color(0, 53, 78, 255);

    public class Proportions {
        public static final int padding = 10;
        public static final int titlebarHeight = 30;
        public static final int guildListWidth = 72;
        public static final int channelListWidth = 240;
        public static final int userListWidth = 240;
    }
}
