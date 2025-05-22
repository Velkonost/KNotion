package com.velkonost.knotion.internal.model.richText.mention

import com.velkonost.knotion.model.richText.RichTextAnnotations
import com.velkonost.knotion.model.richText.UserMentionRichText
import com.velkonost.knotion.model.user.User

internal data class RichTextUserMentionImpl(
    override val plainText: String,
    override val href: String?,
    override val annotations: RichTextAnnotations,
    override val user: User,
) : UserMentionRichText
