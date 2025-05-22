package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.FormulaPropertySpec

internal data class FormulaPropertySpecImpl(
    override val name: String,
    override val id: String,
    override val expression: String,
) : FormulaPropertySpec
