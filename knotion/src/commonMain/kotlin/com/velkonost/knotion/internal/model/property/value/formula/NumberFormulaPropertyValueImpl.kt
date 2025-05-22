package com.velkonost.knotion.internal.model.property.value.formula

import com.velkonost.knotion.model.property.value.NumberFormulaPropertyValue

internal data class NumberFormulaPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: Number?,
) : NumberFormulaPropertyValue
