package com.velkonost.knotion.internal.api.model.property.spec

import com.velkonost.knotion.internal.api.model.property.ApiSelectOption
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiPropertySpecMultiSelect(
    val options: List<ApiSelectOption>,
)
