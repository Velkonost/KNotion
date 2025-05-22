package com.velkonost.knotion.model.date

/**
 * See [Reference](https://developers.notion.com/reference/page#date-property-values).
 */
data class DateOrDateRange(
    val start: DateOrDateTime,
    val end: DateOrDateTime? = null,
)
