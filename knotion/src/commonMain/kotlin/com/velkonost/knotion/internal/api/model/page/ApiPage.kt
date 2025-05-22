package com.velkonost.knotion.internal.api.model.page

import com.velkonost.knotion.internal.api.model.ApiReference
import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiEmojiOrFile
import com.velkonost.knotion.internal.api.model.emojiOrFile.toModel
import com.velkonost.knotion.internal.api.model.property.value.ApiPropertyValue
import com.velkonost.knotion.internal.api.model.property.value.toModel
import com.velkonost.knotion.internal.api.model.toPageModel
import com.velkonost.knotion.internal.model.page.PageImpl
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
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

internal fun ApiPage.toModel(): Page {
    return PageImpl(
        id = id,
        parent = parent.toPageModel(),
        propertyValues = properties.map { (it.key to it.value).toModel() },
        archived = archived,
        created = createdTime.toDateModel().timestamp,
        lastEdited = lastEditedTime.toDateModel().timestamp,
        url = url,
        icon = icon?.toModel(),
        cover = cover?.toModel() as? File,
    )
}