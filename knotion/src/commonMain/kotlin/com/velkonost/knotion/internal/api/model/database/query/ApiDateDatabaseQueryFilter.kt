package com.velkonost.knotion.internal.api.model.database.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/post-database-query).
 */
@Serializable
internal data class ApiDateDatabaseQueryFilter(
    @SerialName("equals")
    val isEquals: String? = null,
    val before: String? = null,
    val after: String? = null,
    @SerialName("on_or_before")
    val onOrBefore: String? = null,
    @SerialName("on_or_after")
    val onOrAfter: String? = null,
    @SerialName("past_week")
    val pastWeek: Map<String, String>? = null,
    @SerialName("past_month")
    val pastMonth: Map<String, String>? = null,
    @SerialName("past_year")
    val pastYear: Map<String, String>? = null,
    @SerialName("next_week")
    val nextWeek: Map<String, String>? = null,
    @SerialName("next_month")
    val nextMonth: Map<String, String>? = null,
    @SerialName("next_year")
    val nextYear: Map<String, String>? = null,
    @SerialName("is_empty")
    val isEmpty: Boolean? = null,
    @SerialName("is_not_empty")
    val isNotEmpty: Boolean? = null,
)
