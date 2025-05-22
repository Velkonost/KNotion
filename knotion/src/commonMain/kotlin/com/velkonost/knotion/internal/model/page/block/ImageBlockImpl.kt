package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.ImageBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class ImageBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val image: File,
    override val caption: RichTextList?,
) : ImageBlock {
    override val children: List<Block>? = null
}
