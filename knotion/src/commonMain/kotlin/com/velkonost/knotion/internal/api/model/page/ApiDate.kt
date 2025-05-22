package com.velkonost.knotion.internal.api.model.page

import com.velkonost.knotion.internal.utils.DateUtils
import com.velkonost.knotion.model.date.Date
import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.date.DateOrDateTime
import com.velkonost.knotion.model.date.DateTime
import kotlinx.datetime.TimeZone
import kotlinx.serialization.Serializable

/**
 * See [Reference](https://developers.notion.com/reference/page#date-property-values).
 */
@Serializable
internal data class ApiDate(
    val start: String,
    val end: String? = null,
)

internal fun ApiDate.toModel(): DateOrDateRange = DateOrDateRange(
    start = start.toDateModel(),
    end = this.end?.toDateModel()
)

internal fun String.toDateModel(): DateOrDateTime {
    return try {
        val timestamp = DateUtils.parse(this)
        val timeZoneId = TimeZone.currentSystemDefault().id
        DateTime(timestamp = timestamp, timeZoneId = timeZoneId)
    } catch (e: Exception) {
        Date(DateUtils.parse(this))
    }
}

internal fun DateOrDateTime.toApi(): String {
    return DateUtils.format(this.timestamp)
}