package com.velkonost.knotion.internal.model.property.value.rollup

import com.velkonost.knotion.model.property.value.NumberRollupPropertyValue

internal data class NumberRollupPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: Number?,
) : NumberRollupPropertyValue
