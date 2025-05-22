package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.EmailPropertySpec

internal data class EmailPropertySpecImpl(
    override val name: String,
    override val id: String
) : EmailPropertySpec
