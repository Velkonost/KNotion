package com.velkonost.knotion.model.richText

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
interface RichTextBase : RichText {
    val linkUrl: String?
}
