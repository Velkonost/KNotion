package com.velkonost.knotion.internal.api.model.richText

import com.velkonost.knotion.model.Color
import com.velkonost.knotion.model.richText.RichTextAnnotations
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiAnnotations(
    val bold: Boolean,
    val italic: Boolean,
    val strikethrough: Boolean,
    val underline: Boolean,
    val code: Boolean,
    val color: String,
)

internal fun ApiAnnotations.toModel(): RichTextAnnotations = RichTextAnnotations(
    bold = bold,
    italic = italic,
    strikethrough = strikethrough,
    underline = underline,
    code = code,
    color = color.toColor()
)

internal fun String.toColor(): Color {
    return when (this) {
        "default" -> Color.DEFAULT
        "gray" -> Color.GRAY
        "brown" -> Color.BROWN
        "orange" -> Color.ORANGE
        "yellow" -> Color.YELLOW
        "green" -> Color.GREEN
        "blue" -> Color.BLUE
        "purple" -> Color.PURPLE
        "pink" -> Color.PINK
        "red" -> Color.RED
        "gray_background" -> Color.GRAY_BACKGROUND
        "brown_background" -> Color.BROWN_BACKGROUND
        "orange_background" -> Color.ORANGE_BACKGROUND
        "yellow_background" -> Color.YELLOW_BACKGROUND
        "green_background" -> Color.GREEN_BACKGROUND
        "blue_background" -> Color.BLUE_BACKGROUND
        "purple_background" -> Color.PURPLE_BACKGROUND
        "pink_background" -> Color.PINK_BACKGROUND
        "red_background" -> Color.RED_BACKGROUND
        else -> Color.UNKNOWN
    }
}