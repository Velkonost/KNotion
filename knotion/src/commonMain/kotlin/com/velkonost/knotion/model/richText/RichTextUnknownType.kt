package com.velkonost.knotion.model.richText

/**
 * This type is returned when a Rich Text of a type unknown to this library is returned by the Notion API.
 *
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface RichTextUnknownType : RichText {
    val type: String
}
