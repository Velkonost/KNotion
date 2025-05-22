package com.velkonost.knotion.model.richText

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
sealed interface RichText {
    val plainText: String
    val href: String?
    val annotations: RichTextAnnotations
}
