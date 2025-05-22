package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiNumberDatabaseQueryFilter(
    @SerialName("equals")
    val isEquals: Double? = null,
    @SerialName("does_not_equal")
    val doesNotEqual: Double? = null,
    @SerialName("greater_than")
    val greaterThan: Double? = null,
    @SerialName("less_than")
    val lessThan: Double? = null,
    @SerialName("greater_than_or_equal_to")
    val greaterThanOrEqualTo: Double? = null,
    @SerialName("less_than_or_equal_to")
    val lessThanOrEqualTo: Double? = null,
    @SerialName("is_empty")
    val isEmpty: Boolean? = null,
    @SerialName("is_not_empty")
    val isNotEmpty: Boolean? = null,
)
