package com.velkonost.knotion.internal.api.model.property.value

import com.velkonost.knotion.internal.api.model.page.ApiDate
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#all-property-values).
 */
@Serializable
internal data class ApiPropertyValueFormula(
    val type: String,
    val string: String? = null,
    val number: Long? = null,
    val boolean: Boolean? = null,
    val date: ApiDate? = null,
)
