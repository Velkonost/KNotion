package com.velkonost.knotion.internal.api.model.richtext

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiRichTextMentionPage(
    val id: String,
)
