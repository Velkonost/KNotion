package com.velkonost.knotion.internal.api.model.richText

import com.velkonost.knotion.internal.api.model.page.ApiDate
import com.velkonost.knotion.internal.api.model.user.ApiUser
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/rich-text).
 */
@Serializable
internal data class ApiRichTextMention(
    val type: String,
    val user: ApiUser? = null,
    val page: ApiRichTextMentionPage? = null,
    val database: ApiRichTextMentionDatabase? = null,
    val date: ApiDate? = null,
)
