package com.velkonost.knotion.internal.model.property.value.rollup

import com.velkonost.knotion.model.property.value.ArrayRollupPropertyValue
import com.velkonost.knotion.model.property.value.PropertyValue

internal data class ArrayRollupPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: List<PropertyValue<*>>?,
) : ArrayRollupPropertyValue
