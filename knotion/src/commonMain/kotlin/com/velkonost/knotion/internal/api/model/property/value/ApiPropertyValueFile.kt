package com.velkonost.knotion.internal.api.model.property.value

import com.velkonost.knotion.internal.api.model.emojiOrFile.ApiFile
import com.velkonost.knotion.internal.model.emojiOrFile.FileImpl
import com.velkonost.knotion.model.emojiOrFile.File
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
internal data class ApiPropertyValueFile(
    val name: String? = null,
    val file: ApiFile? = null,
    val external: ApiFile? = null,
)

internal fun ApiPropertyValueFile.toModel(): File = FileImpl(
    name = name,
    url = file?.url ?: external?.url ?: "Unknown URL"
)