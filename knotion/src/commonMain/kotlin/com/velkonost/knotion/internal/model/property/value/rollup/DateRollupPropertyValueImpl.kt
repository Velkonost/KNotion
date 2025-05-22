package com.velkonost.knotion.internal.model.property.value.rollup

import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.property.value.DateRollupPropertyValue

internal data class DateRollupPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: DateOrDateRange?,
) : DateRollupPropertyValue
