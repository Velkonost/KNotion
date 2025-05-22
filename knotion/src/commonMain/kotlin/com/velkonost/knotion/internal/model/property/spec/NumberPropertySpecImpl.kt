package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.NumberPropertySpec

internal data class NumberPropertySpecImpl(
    override val name: String,
    override val id: String,
    override val format: NumberPropertySpec.NumberFormat,
) : NumberPropertySpec
