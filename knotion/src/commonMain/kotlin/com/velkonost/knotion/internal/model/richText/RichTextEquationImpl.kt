package com.velkonost.knotion.internal.model.richText

import com.velkonost.knotion.model.richText.RichTextAnnotations
import com.velkonost.knotion.model.richText.RichTextEquation

internal data class RichTextEquationImpl(
    override val plainText: String,
    override val href: String?,
    override val annotations: RichTextAnnotations,
    override val expression: String,
) : RichTextEquation
