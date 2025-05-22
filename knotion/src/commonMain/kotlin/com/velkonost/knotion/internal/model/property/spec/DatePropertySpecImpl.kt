package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.DatePropertySpec

internal data class DatePropertySpecImpl(
    override val name: String,
    override val id: String
) : DatePropertySpec
