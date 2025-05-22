package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.LastEditedTimePropertySpec

internal data class LastEditedTimePropertySpecImpl(
    override val name: String,
    override val id: String,
) : LastEditedTimePropertySpec
