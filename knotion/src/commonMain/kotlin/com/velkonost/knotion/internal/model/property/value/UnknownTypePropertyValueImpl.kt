package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.UnknownTypePropertyValue

internal data class UnknownTypePropertyValueImpl(
    override val id: String,
    override val name: String,
    override val type: String,
    override val value: Nothing? = null,
) : UnknownTypePropertyValue
