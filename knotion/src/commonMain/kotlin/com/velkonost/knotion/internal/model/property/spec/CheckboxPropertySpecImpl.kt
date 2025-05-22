package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.CheckboxPropertySpec

internal data class CheckboxPropertySpecImpl(
    override val name: String,
    override val id: String
) : CheckboxPropertySpec
