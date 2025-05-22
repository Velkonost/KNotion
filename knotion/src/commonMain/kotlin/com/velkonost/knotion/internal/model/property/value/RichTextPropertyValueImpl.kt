package com.velkonost.knotion.internal.model.property.value

import com.velkonost.knotion.model.property.value.RichTextPropertyValue
import com.velkonost.knotion.model.richText.RichTextList

internal data class RichTextPropertyValueImpl(
    override val id: String,
    override val name: String,
    override val value: RichTextList,
) : RichTextPropertyValue
