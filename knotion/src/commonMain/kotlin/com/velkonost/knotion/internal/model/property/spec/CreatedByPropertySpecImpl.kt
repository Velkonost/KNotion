package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.CreatedByPropertySpec

internal data class CreatedByPropertySpecImpl(
    override val name: String,
    override val id: String
) : CreatedByPropertySpec
