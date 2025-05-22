package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.PhoneNumberPropertyValue

internal data class PhoneNumberPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: String?,
) : PhoneNumberPropertyValue
