package com.velkonost.knotion.internal.api.model.page.request

import com.velkonost.knotion.internal.api.model.ApiReference
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.property.value.PropertyValue
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-page).
 */
@Serializable
internal data class CreatePageRequest(
    val parent: ApiReference,
    val properties: List<PropertyStringValue>,
    val children: List<Block>? = null,
    val icon: EmojiOrFile? = null,
    val cover: File? = null,
)

@Serializable
internal data class PropertyStringValue(
    val id: String,
    val name: String,
    val value: String
)

internal fun PropertyValue<*>.toStringValue() = PropertyStringValue(id, name, value.toString())