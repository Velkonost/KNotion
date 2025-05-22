package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.SelectOption
import com.velkonost.knotion.model.property.spec.MultiSelectPropertySpec

internal data class MultiSelectPropertySpecImpl(
    override val name: String,
    override val id: String,
    override val options: List<SelectOption>,
) : MultiSelectPropertySpec
