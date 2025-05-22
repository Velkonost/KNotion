package com.velkonost.knotion.internal.model.property.value.formula

import com.velkonost.knotion.model.property.value.StringFormulaPropertyValue

internal data class StringFormulaPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: String?,
) : StringFormulaPropertyValue
