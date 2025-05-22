package com.velkonost.knotion.internal.api.model.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiRichText(
    @SerialName("plain_text")
    val plainText: String,
    val href: String? = null,
    val annotations: ApiAnnotations,
    val type: String,
    val text: ApiRichTextText? = null,
    val mention: ApiRichTextMention? = null,
    val equation: ApiRichTextEquation? = null,
)
