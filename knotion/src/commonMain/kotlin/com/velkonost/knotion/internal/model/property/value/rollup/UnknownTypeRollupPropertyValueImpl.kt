package com.velkonost.knotion.internal.model.property.value.rollup

import com.velkonost.knotion.model.property.value.UnknownTypeRollupPropertyValue

internal data class UnknownTypeRollupPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val type: String,
    override val value: Nothing? = null,
) : UnknownTypeRollupPropertyValue
