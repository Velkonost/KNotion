package com.velkonost.knotion.model.richText

import com.velkonost.knotion.model.Color
import kotlin.jvm.JvmField

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
data class RichTextAnnotations(
    val bold: Boolean = false,
    val italic: Boolean = false,
    val strikethrough: Boolean = false,
    val underline: Boolean = false,
    val code: Boolean = false,
    val color: Color = Color.DEFAULT,
) {

    companion object {
        @JvmField
        val DEFAULT: RichTextAnnotations = RichTextAnnotations()

        @JvmField
        val BOLD: RichTextAnnotations = RichTextAnnotations(bold = true)

        @JvmField
        val ITALIC: RichTextAnnotations = RichTextAnnotations(italic = true)

        @JvmField
        val STRIKETHROUGH: RichTextAnnotations = RichTextAnnotations(strikethrough = true)

        @JvmField
        val UNDERLINE: RichTextAnnotations = RichTextAnnotations(underline = true)

        @JvmField
        val CODE: RichTextAnnotations = RichTextAnnotations(code = true)
    }
}
