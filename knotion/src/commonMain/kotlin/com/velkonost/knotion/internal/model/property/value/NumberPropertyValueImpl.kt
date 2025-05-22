package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.NumberPropertyValue

internal data class NumberPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: Number?,
) : NumberPropertyValue
