package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.utils.DateUtils
import com.velkonost.knotion.model.Timestamp
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.richText.RichTextAnnotations
import com.velkonost.knotion.model.richText.RichTextList
import com.velkonost.knotion.internal.model.page.block.BookmarkBlockImpl
import com.velkonost.knotion.internal.model.page.block.BulletedListItemBlockImpl
import com.velkonost.knotion.internal.model.page.block.CalloutBlockImpl
import com.velkonost.knotion.internal.model.page.block.CodeBlockImpl
import com.velkonost.knotion.internal.model.page.block.DividerBlockImpl
import com.velkonost.knotion.internal.model.page.block.EmbedBlockImpl
import com.velkonost.knotion.internal.model.page.block.EquationBlockImpl
import com.velkonost.knotion.internal.model.page.block.Heading1BlockImpl
import com.velkonost.knotion.internal.model.page.block.Heading2BlockImpl
import com.velkonost.knotion.internal.model.page.block.Heading3BlockImpl
import com.velkonost.knotion.internal.model.page.block.ImageBlockImpl
import com.velkonost.knotion.internal.model.page.block.NumberedListItemBlockImpl
import com.velkonost.knotion.internal.model.page.block.ParagraphBlockImpl
import com.velkonost.knotion.internal.model.page.block.QuoteBlockImpl
import com.velkonost.knotion.internal.model.page.block.SyncedBlockImpl
import com.velkonost.knotion.internal.model.page.block.TableOfContentsBlockImpl
import com.velkonost.knotion.internal.model.page.block.ToDoBlockImpl
import com.velkonost.knotion.internal.model.page.block.ToggleBlockImpl
import com.velkonost.knotion.internal.model.page.block.VideoBlockImpl
import com.velkonost.knotion.internal.model.emojiOrFile.FileImpl
import kotlin.jvm.JvmOverloads

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
sealed interface Block {
    val id: UuidString
    val created: Timestamp
    val lastEdited: Timestamp
    val children: List<Block>?
}

class MutableBlockList(
    private val blockList: MutableList<Block> = mutableListOf(),
) : List<Block> by blockList {

    private fun add(block: Block): MutableBlockList {
        blockList.add(block)
        return this
    }

    @JvmOverloads
    fun paragraph(richTextList: RichTextList, children: BlockListProducer? = null): MutableBlockList =
        add(
            ParagraphBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            richTextList,
            children()
        )
        )

    @JvmOverloads
    fun paragraph(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = paragraph(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        children = children,
    )

    @JvmOverloads
    fun heading1(richTextList: RichTextList): MutableBlockList =
        add(com.velkonost.knotion.model.page.block.heading1(richTextList))

    @JvmOverloads
    fun heading1(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.heading1(text, linkUrl, annotations))

    fun heading2(richTextList: RichTextList): MutableBlockList =
        add(com.velkonost.knotion.model.page.block.heading2(richTextList))

    @JvmOverloads
    fun heading2(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.heading2(text, linkUrl, annotations))

    fun heading3(richTextList: RichTextList): MutableBlockList =
        add(com.velkonost.knotion.model.page.block.heading3(richTextList))

    @JvmOverloads
    fun heading3(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.heading3(text, linkUrl, annotations))

    @JvmOverloads
    fun bullet(richTextList: RichTextList, children: BlockListProducer? = null): MutableBlockList =
        add(
            BulletedListItemBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            richTextList,
            children())
        )

    @JvmOverloads
    fun bullet(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = bullet(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        children = children,
    )

    @JvmOverloads
    fun number(richTextList: RichTextList, children: BlockListProducer? = null): MutableBlockList =
        add(
            NumberedListItemBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            richTextList,
            children()
        )
        )

    @JvmOverloads
    fun number(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = number(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        children = children,
    )

    @JvmOverloads
    fun toDo(richTextList: RichTextList, checked: Boolean, children: BlockListProducer? = null): MutableBlockList =
        add(
            ToDoBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            richTextList,
            checked,
            children()
        )
        )

    @JvmOverloads
    fun toDo(
        text: String,
        checked: Boolean,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = toDo(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        checked = checked,
        children = children,
    )

    @JvmOverloads
    fun toggle(richTextList: RichTextList, children: BlockListProducer? = null): MutableBlockList =
        add(
            ToggleBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            richTextList,
            children()
        )
        )

    @JvmOverloads
    fun toggle(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = toggle(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        children = children,
    )

    @JvmOverloads
    fun bookmark(
        url: String,
        caption: RichTextList? = null,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.bookmark(url, caption))

    @JvmOverloads
    fun bookmark(
        url: String,
        caption: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.bookmark(url, caption, linkUrl, annotations))

    fun code(
        language: String,
        text: RichTextList,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.code(language, text))

    @JvmOverloads
    fun code(
        language: String,
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.code(language, text, linkUrl, annotations))

    fun equation(
        expression: String,
    ): MutableBlockList = add(com.velkonost.knotion.model.page.block.equation(expression))

    @JvmOverloads
    fun quote(
        richTextList: RichTextList,
        children: BlockListProducer? = null,
    ): MutableBlockList =
        add(
            QuoteBlockImpl(
            id = "",
            created = DateUtils.nowMillis(),
            lastEdited = DateUtils.nowMillis(),
            text = richTextList,
            children = children()
        )
        )


    @JvmOverloads
    fun quote(
        text: String,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList = quote(
        richTextList = RichTextList().text(text, linkUrl, annotations),
        children = children,
    )

    fun embed(url: String): MutableBlockList = add(com.velkonost.knotion.model.page.block.embed(url))

    @JvmOverloads
    fun callout(
        richTextList: RichTextList,
        icon: EmojiOrFile? = null,
        children: BlockListProducer? = null,
    ): MutableBlockList = add(
        CalloutBlockImpl(
        id = "",
        created = DateUtils.nowMillis(),
        lastEdited = DateUtils.nowMillis(),
        children = children(),
        text = richTextList,
        icon = icon
    )
    )

    @JvmOverloads
    fun callout(
        text: String,
        icon: EmojiOrFile? = null,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
        children: BlockListProducer? = null,
    ): MutableBlockList =
        callout(
            richTextList = RichTextList().text(text, linkUrl, annotations),
            icon = icon,
            children = children
        )

    fun divider(): MutableBlockList = add(com.velkonost.knotion.model.page.block.divider())

    fun tableOfContents(): MutableBlockList = add(com.velkonost.knotion.model.page.block.tableOfContents())

    fun image(
        url: String,
        caption: RichTextList? = null,
    ) = add(com.velkonost.knotion.model.page.block.image(url, caption))

    @JvmOverloads
    fun image(
        url: String,
        caption: String? = null,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(com.velkonost.knotion.model.page.block.image(url, caption, linkUrl, annotations))

    fun video(
        url: String,
        caption: RichTextList? = null,
    ) = add(com.velkonost.knotion.model.page.block.video(url, caption))

    @JvmOverloads
    fun video(
        url: String,
        caption: String? = null,
        linkUrl: String? = null,
        annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
    ) = add(com.velkonost.knotion.model.page.block.video(url, caption, linkUrl, annotations))

    fun syncedBlock(syncedFrom: UuidString): MutableBlockList =
        add(com.velkonost.knotion.model.page.block.syncedBlock(syncedFrom))
}

typealias BlockListProducer = MutableBlockList.() -> Unit

internal operator fun BlockListProducer?.invoke() = this?.let { producer ->
    MutableBlockList().apply { producer(this) }
}


fun content(content: BlockListProducer) = content()

fun paragraph(richTextList: RichTextList): Block = ParagraphBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList,
    null,
)

@JvmOverloads
fun paragraph(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = paragraph(
    richTextList = RichTextList().text(text, linkUrl, annotations),
)

fun heading1(richTextList: RichTextList): Block = Heading1BlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList
)

@JvmOverloads
fun heading1(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = heading1(
    richTextList = RichTextList().text(text, linkUrl, annotations),
)

fun heading2(richTextList: RichTextList): Block = Heading2BlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList
)

@JvmOverloads
fun heading2(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = heading2(
    richTextList = RichTextList().text(text, linkUrl, annotations)
)

fun heading3(richTextList: RichTextList): Block = Heading3BlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList
)

@JvmOverloads
fun heading3(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = heading3(
    richTextList = RichTextList().text(text, linkUrl, annotations)
)

fun bulletedListItem(richTextList: RichTextList): Block = BulletedListItemBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList,
    null,
)

@JvmOverloads
fun bulletedListItem(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = bulletedListItem(
    richTextList = RichTextList().text(text, linkUrl, annotations),
)

fun numberedListItem(richTextList: RichTextList): Block = NumberedListItemBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList,
    null
)

@JvmOverloads
fun numberedListItem(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = numberedListItem(
    richTextList = RichTextList().text(text, linkUrl, annotations),
)

fun toDo(richTextList: RichTextList, checked: Boolean): Block = ToDoBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    richTextList,
    checked,
    null
)

@JvmOverloads
fun toDo(
    text: String,
    checked: Boolean,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = toDo(
    richTextList = RichTextList().text(text, linkUrl, annotations),
    checked = checked,
)

fun toggle(richTextList: RichTextList): Block = ToggleBlockImpl(
    id = "",
    created = RichTextAnnotations,
    lastEdited = RichTextAnnotations,
    richTextList,
    null,
)

@JvmOverloads
fun toggle(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = toggle(
    richTextList = RichTextList().text(text, linkUrl, annotations),
)

fun bookmark(
    url: String,
    caption: RichTextList? = null,
): Block = BookmarkBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    url = url,
    caption = caption
)

@JvmOverloads
fun bookmark(
    url: String,
    caption: String? = null,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = bookmark(
    url = url,
    caption = caption?.let { RichTextList().text(it, linkUrl, annotations) }
)

fun code(
    language: String,
    text: RichTextList,
): Block = CodeBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    text = text,
    language = language
)

@JvmOverloads
fun code(
    language: String,
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = code(
    language = language,
    text = RichTextList().text(text, linkUrl, annotations),
)

fun equation(
    expression: String,
): Block = EquationBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    expression = expression
)

fun quote(richTextList: RichTextList): Block = QuoteBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    text = richTextList,
    children = null
)

@JvmOverloads
fun quote(
    text: String,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = quote(
    RichTextList().text(text, linkUrl, annotations)
)

fun embed(url: String): Block = EmbedBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    url = url
)

fun callout(
    richTextList: RichTextList,
    icon: EmojiOrFile? = null,
): Block = CalloutBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    children = null,
    text = richTextList,
    icon = icon
)

@JvmOverloads
fun callout(
    text: String,
    icon: EmojiOrFile? = null,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = callout(
    richTextList = RichTextList().text(text, linkUrl, annotations),
    icon = icon
)


fun divider(): Block = DividerBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
)

fun tableOfContents(): Block = TableOfContentsBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis()
)

fun image(
    url: String,
    caption: RichTextList? = null,
): Block = ImageBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    image = FileImpl(name = "image", url = url),
    caption = caption,
)

@JvmOverloads
fun image(
    url: String,
    caption: String? = null,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = image(
    url = url,
    caption = caption?.let { RichTextList().text(it, linkUrl, annotations) },
)

fun video(
    url: String,
    caption: RichTextList? = null,
): Block = VideoBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    video = FileImpl(name = "video", url = url),
    caption = caption,
)

@JvmOverloads
fun video(
    url: String,
    caption: String? = null,
    linkUrl: String? = null,
    annotations: RichTextAnnotations = RichTextAnnotations.DEFAULT,
): Block = video(
    url = url,
    caption = caption?.let { RichTextList().text(it, linkUrl, annotations) },
)

fun syncedBlock(syncedFrom: UuidString): Block = SyncedBlockImpl(
    id = "",
    created = DateUtils.nowMillis(),
    lastEdited = DateUtils.nowMillis(),
    syncedFrom = syncedFrom
)
