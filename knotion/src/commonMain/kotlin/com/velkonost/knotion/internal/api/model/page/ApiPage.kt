package com.velkonost.knotion.internal.api.model.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page).
 */
@Serializable
internal data class ApiPage(
    val id: String,
    val parent: ApiReference,
    val properties: Map<String, ApiPropertyValue>,
    val archived: Boolean,
    @SerialName("created_time")
    val createdTime: String,
    @SerialName("last_edited_time")
    val lastEditedTime: String,
    val url: String,
    val icon: ApiEmojiOrFile?,
    // Technically this can only be "file" or "external", never "emoji"
    val cover: ApiEmojiOrFile?,
)
