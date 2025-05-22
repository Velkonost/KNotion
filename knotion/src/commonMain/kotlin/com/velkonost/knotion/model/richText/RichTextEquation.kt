package com.velkonost.knotion.model.richText

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface RichTextEquation : RichText {
    val expression: String
}
