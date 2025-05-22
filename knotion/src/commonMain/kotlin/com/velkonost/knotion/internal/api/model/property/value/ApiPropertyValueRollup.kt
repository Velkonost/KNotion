package com.velkonost.knotion.internal.api.model.property.value

import com.velkonost.knotion.internal.api.model.page.ApiDate
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
internal data class ApiPropertyValueRollup(
    val type: String,
    val number: String? = null,
    val date: ApiDate? = null,
    val array: List<ApiPropertyValue>? = null,
)
