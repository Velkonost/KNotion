package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiRelationDatabaseQueryFilter(
    val contains: String? = null,
    @SerialName("does_not_contain")
    val doesNotContains: String? = null,
    @SerialName("is_empty")
    val isEmpty: Boolean? = null,
    @SerialName("is_not_empty")
    val isNotEmpty: Boolean? = null,
)
