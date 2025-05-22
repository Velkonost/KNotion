package com.velkonost.knotion.internal.model.property

import com.velkonost.knotion.model.Color
import com.velkonost.knotion.model.property.SelectOption

internal data class SelectOptionImpl(
    override val name: String,
    override val id: String,
    override val color: Color
) : SelectOption
