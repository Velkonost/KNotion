package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.property.value.DatePropertyValue

internal data class DatePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: DateOrDateRange?,
) : DatePropertyValue
