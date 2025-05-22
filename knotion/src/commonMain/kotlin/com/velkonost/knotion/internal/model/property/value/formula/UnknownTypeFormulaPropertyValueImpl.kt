package com.velkonost.knotion.internal.model.property.value.formula

import com.velkonost.knotion.model.property.value.UnknownTypeFormulaPropertyValue

internal data class UnknownTypeFormulaPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val type: String,
    override val value: Nothing? = null,
) : UnknownTypeFormulaPropertyValue
