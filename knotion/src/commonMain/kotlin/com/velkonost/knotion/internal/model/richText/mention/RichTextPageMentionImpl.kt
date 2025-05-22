package com.velkonost.knotion.internal.model.richText.mention

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.richText.PageMentionRichText
import com.velkonost.knotion.model.richText.RichTextAnnotations

internal data class RichTextPageMentionImpl(
    override val plainText: String,
    override val href: String?,
    override val annotations: RichTextAnnotations,
    override val pageId: UuidString,
) : PageMentionRichText
