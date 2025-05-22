package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.property.spec.UnknownTypePropertySpec

internal data class UnknownTypePropertySpecImpl(
    override val id: UuidString,
    override val name: String,
    override val type: String?,
) : UnknownTypePropertySpec
