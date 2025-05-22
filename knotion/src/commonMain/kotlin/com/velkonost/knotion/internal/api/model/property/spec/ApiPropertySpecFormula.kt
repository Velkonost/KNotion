package com.velkonost.knotion.internal.api.model.property.spec

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/database).
 */
@Serializable
internal data class ApiPropertySpecFormula(
    val expression: String,
)
