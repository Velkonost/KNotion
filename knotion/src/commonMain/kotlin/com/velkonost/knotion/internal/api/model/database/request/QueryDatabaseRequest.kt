package com.velkonost.knotion.internal.api.model.database.request

import com.velkonost.knotion.internal.api.model.database.query.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class QueryDatabaseRequest(
    val filter: DatabaseQueryRequestFilters? = null,
    val sorts: List<ApiDatabaseQuerySort>? = null,
    @SerialName("start_cursor")
    val startCursor: String? = null,
)

@Serializable
internal data class DatabaseQueryRequestFilters(
    val or: List<DatabaseQueryRequestFilter>? = null,
    val and: List<DatabaseQueryRequestFilter>? = null,
)

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class DatabaseQueryRequestFilter(
    val property: String,
    val title: ApiTextDatabaseQueryFilter? = null,
    val text: ApiTextDatabaseQueryFilter? = null,
    val number: ApiNumberDatabaseQueryFilter? = null,
    val checkbox: ApiCheckboxDatabaseQueryFilter? = null,
    val select: ApiSelectDatabaseQueryFilter? = null,
    @SerialName("multi_select")
    val multiSelect: ApiMultiSelectDatabaseQueryFilter? = null,
    val date: ApiDateDatabaseQueryFilter? = null,
    val people: ApiPeopleDatabaseQueryFilter? = null,
    val files: ApiFilesDatabaseQueryFilter? = null,
    val url: ApiTextDatabaseQueryFilter? = null,
    val email: ApiTextDatabaseQueryFilter? = null,
    @SerialName("phone_number")
    val phoneNumber: ApiTextDatabaseQueryFilter? = null,
    val relation: ApiRelationDatabaseQueryFilter? = null,
    val formula: ApiFormulaDatabaseQueryFilter? = null,
    @SerialName("created_by")
    val createdBy: ApiPeopleDatabaseQueryFilter? = null,
    @SerialName("created_time")
    val createdTime: ApiDateDatabaseQueryFilter? = null,
    @SerialName("last_edited_by")
    val lastEditedBy: ApiPeopleDatabaseQueryFilter? = null,
    @SerialName("last_edited_time")
    val lastEditedTime: ApiDateDatabaseQueryFilter? = null,
)
