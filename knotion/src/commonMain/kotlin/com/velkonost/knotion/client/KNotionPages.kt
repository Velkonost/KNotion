package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.DatabaseReference
import com.velkonost.knotion.model.PageReference
import com.velkonost.knotion.model.emojiOrFile.EmojiOrFile
import com.velkonost.knotion.model.emojiOrFile.File
import com.velkonost.knotion.model.page.Page
import com.velkonost.knotion.model.page.block.BlockListProducer
import com.velkonost.knotion.model.page.block.MutableBlockList
import com.velkonost.knotion.model.property.value.PropertyValueList
import com.velkonost.knotion.model.richText.RichTextList

interface KNotionPages {
    /**
     * Retrieve a page.
     * @see <a href="https://developers.notion.com/reference/get-page">Retrieve a page</a>
     */
    suspend fun getPage(id: UuidString): Page

    /**
     * Create a page in a database.
     * @see <a href="https://developers.notion.com/reference/post-page">Create a page</a>
     */
    suspend fun createPage(
        parentDatabase: DatabaseReference,
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertyValueList = PropertyValueList(),
        content: MutableBlockList? = null,
    ): Page

    /**
     * Create a page in a database.
     * @see <a href="https://developers.notion.com/reference/post-page">Create a page</a>
     */
    suspend fun createPage(
        parentDatabase: DatabaseReference,
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertyValueList = PropertyValueList(),
        content: BlockListProducer,
    ): Page

    /**
     * Create a page in a page.
     * @see <a href="https://developers.notion.com/reference/post-page">Create a page</a>
     */
    suspend fun createPage(
        parentPage: PageReference,
        title: RichTextList = RichTextList(),
        icon: EmojiOrFile? = null,
        cover: File? = null,
        content: MutableBlockList? = null,
    ): Page

    /**
     * Create a page in a page.
     * @see <a href="https://developers.notion.com/reference/post-page">Create a page</a>
     */
    suspend fun createPage(
        parentPage: PageReference,
        title: RichTextList = RichTextList(),
        icon: EmojiOrFile? = null,
        cover: File? = null,
        content: BlockListProducer,
    ): Page

    /**
     * Update a page.
     * @see <a href="https://developers.notion.com/reference/patch-page">Update page properties</a>
     */
    suspend fun updatePage(
        id: UuidString,
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertyValueList,
    ): Page

    /**
     * Mark the page as archived or not.
     * @see <a href="https://developers.notion.com/reference/patch-page#archive-delete-a-page">Archive a page</a>
     */
    suspend fun setPageArchived(id: UuidString, archived: Boolean): Page
}