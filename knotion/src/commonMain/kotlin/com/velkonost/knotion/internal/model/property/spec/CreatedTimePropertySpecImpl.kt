package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.CreatedTimePropertySpec

internal data class CreatedTimePropertySpecImpl(
    override val name: String,
    override val id: String
) : CreatedTimePropertySpec
