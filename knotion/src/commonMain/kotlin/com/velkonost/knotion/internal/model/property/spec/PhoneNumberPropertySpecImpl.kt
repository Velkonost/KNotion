package com.velkonost.knotion.internal.model.property.spec

import com.velkonost.knotion.model.property.spec.PhoneNumberPropertySpec

internal data class PhoneNumberPropertySpecImpl(
    override val name: String,
    override val id: String
) : PhoneNumberPropertySpec
