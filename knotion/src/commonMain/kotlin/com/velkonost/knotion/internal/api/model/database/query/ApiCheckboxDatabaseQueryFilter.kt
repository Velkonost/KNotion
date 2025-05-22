package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiCheckboxDatabaseQueryFilter(
    @SerialName("equals")
    val isEquals: Boolean? = null,
    @SerialName("does_not_equal")
    val doesNotEqual: Boolean? = null,
)
