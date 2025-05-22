package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.VideoBlock
import com.velkonost.knotion.model.richText.RichTextList

internal data class VideoBlockImpl(
    override val id: UuidString,
    override val created: Timestamp,
    override val lastEdited: Timestamp,
    override val video: File,
    override val caption: RichTextList?,
) : VideoBlock {
    override val children: List<Block>? = null
}
