package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.UrlPropertySpec

internal data class UrlPropertySpecImpl(
    override val name: String,
    override val id: String
) : UrlPropertySpec
