package com.velkonost.knotion.internal.model.property.value.formula

import com.velkonost.knotion.model.property.value.BooleanFormulaPropertyValue

internal data class BooleanFormulaPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: Boolean,
) : BooleanFormulaPropertyValue
