package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiFormulaDatabaseQueryFilter(
    val text: ApiTextDatabaseQueryFilter? = null,
    val checkbox: ApiCheckboxDatabaseQueryFilter? = null,
    val number: ApiNumberDatabaseQueryFilter? = null,
    val date: ApiDateDatabaseQueryFilter? = null,
)
