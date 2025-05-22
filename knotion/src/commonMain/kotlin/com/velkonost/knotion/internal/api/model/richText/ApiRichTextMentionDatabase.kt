package com.velkonost.knotion.internal.api.model.richText

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiRichTextMentionDatabase(
    val id: String,
)
