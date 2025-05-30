package com.velkonost.knotion.model

/**
 * Enum representing all possible Notion color values for text and backgrounds.
 *
 * These colors are used for text annotations, backgrounds, and other colorable elements in Notion.
 * The values correspond to the color names used by the Notion API.
 *
 * @property UNKNOWN Used when the Notion API returns a color not recognized by this library.
 * @property DEFAULT The default color (usually black text or white background).
 * @property GRAY, BROWN, ORANGE, YELLOW, GREEN, BLUE, PURPLE, PINK, RED Standard text colors.
 * @property GRAY_BACKGROUND, ..._BACKGROUND Background color variants for each color.
 */
enum class Color {
    /**
     * This type is returned when a type unknown to this library is returned by the Notion API.
     */
    UNKNOWN,

    DEFAULT,
    GRAY,
    BROWN,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    PURPLE,
    PINK,
    RED,
    GRAY_BACKGROUND,
    BROWN_BACKGROUND,
    ORANGE_BACKGROUND,
    YELLOW_BACKGROUND,
    GREEN_BACKGROUND,
    BLUE_BACKGROUND,
    PURPLE_BACKGROUND,
    PINK_BACKGROUND,
    RED_BACKGROUND,
}
