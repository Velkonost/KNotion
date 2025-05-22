package com.velkonost.knotion.internal.model.property.value.formula

import com.velkonost.knotion.model.date.DateOrDateRange
import com.velkonost.knotion.model.property.value.DateFormulaPropertyValue

internal data class DateFormulaPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: DateOrDateRange?,
) : DateFormulaPropertyValue
