package com.velkonost.knotion.internal.utils

import com.velkonost.knotion.model.Timestamp
import kotlinx.datetime.*
import kotlinx.datetime.format.char

internal object DateUtils {

    private val formatter = LocalDateTime.Format {
        year()
        char('-')
        monthNumber()
        char('-')
        dayOfMonth()
        char('T')
        hour()
        char(':')
        minute()
        char(':')
        second()
        char('.')
        chars("000")
        char('Z')
    }

    fun nowMillis(): Timestamp {
        return Clock.System.now().toEpochMilliseconds()
    }

    fun format(timestamp: Timestamp): String {
        val localDateTime = Instant.fromEpochMilliseconds(timestamp).toLocalDateTime(TimeZone.currentSystemDefault())
        return formatter.format(localDateTime)
    }

    fun parse(formattedDate: String): Timestamp {
        return formatter.parse(formattedDate).toInstant(TimeZone.UTC).toEpochMilliseconds()
    }

}