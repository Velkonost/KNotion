package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiDatabaseQuerySort(
    val property: String,
    val direction: String,
)
