package com.velkonost.knotion.internal.api.model.database

import com.velkonost.knotion.internal.api.model.ApiReference
import com.velkonost.knotion.internal.api.model.richtext.ApiRichText
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiDatabase(
    val id: String,
    val parent: ApiReference,
    val title: List<ApiRichText>,
    val properties: Map<String, ApiPropertySpec>,
    @SerialName("created_time")
    val createdTime: String,
    @SerialName("last_edited_time")
    val lastEditedTime: String,
    val icon: ApiEmojiOrFile?,
    // Technically this can only be "file" or "external", never "emoji"
    val cover: ApiEmojiOrFile?,
)
