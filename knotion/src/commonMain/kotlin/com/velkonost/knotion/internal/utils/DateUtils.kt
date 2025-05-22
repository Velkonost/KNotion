package com.velkonost.knotion.internal.utils

import com.velkonost.knotion.model.Timestamp
import kotlinx.datetime.Clock

internal object DateUtils {

    fun nowMillis(): Timestamp {
        return Clock.System.now().toEpochMilliseconds()
    }

}