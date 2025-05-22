package com.velkonost.knotion.model.date

import com.velkonost.knotion.model.Timestamp
import kotlinx.datetime.TimeZone

sealed class DateOrDateTime(open val timestamp: Timestamp)

data class Date(override val timestamp: Timestamp) : DateOrDateTime(timestamp)

data class DateTime(
    override val timestamp: Timestamp,
    val timeZoneId: String = TimeZone.currentSystemDefault().id,
) : DateOrDateTime(timestamp)
