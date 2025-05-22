package com.velkonost.knotion.internal.api.model.property.value

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
internal data class ApiPropertyValueRelation(
    val id: String,
)
