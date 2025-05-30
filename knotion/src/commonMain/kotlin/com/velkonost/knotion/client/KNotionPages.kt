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

/**
 * Interface for managing Notion pages through the Notion API.
 * This interface provides methods to create, retrieve, update, and archive pages in your Notion workspace.
 * Pages can be created either as children of databases or other pages, with support for various content types
 * and properties.
 * 
 * Example usage:
 * ```
 * // Retrieve a page
 * val page = client.pages.getPage("page-id")
 * 
 * // Create a page in a database
 * val newPage = client.pages.createPage(
 *     parentDatabase = DatabaseReference("database-id"),
 *     properties = PropertyValueList().apply {
 *         title("Name", "My New Page")
 *     }
 * )
 * ```
 */
interface KNotionPages {
    /**
     * Retrieves a page by its ID.
     * This method fetches all page properties, content, and metadata.
     * 
     * @param id The unique identifier of the page (UUID format)
     * @return A [Page] object containing all page data
     * @throws NotionApiException if the page doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/get-page">Retrieve a page</a>
     */
    suspend fun getPage(id: UuidString): Page

    /**
     * Creates a new page as a child of a database.
     * This method allows you to create a page with custom properties and optional content blocks.
     * 
     * @param parentDatabase Reference to the parent database
     * @param icon Optional emoji or file to use as the page icon
     * @param cover Optional file to use as the page cover
     * @param properties List of property values for the page (required for database pages)
     * @param content Optional list of blocks to add as page content
     * @return The created [Page] object
     * @throws NotionApiException if the database doesn't exist or the API request fails
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
     * Creates a new page as a child of a database using a block producer.
     * This overload allows for more dynamic block creation using a [BlockListProducer].
     * 
     * @param parentDatabase Reference to the parent database
     * @param icon Optional emoji or file to use as the page icon
     * @param cover Optional file to use as the page cover
     * @param properties List of property values for the page (required for database pages)
     * @param content Block producer function to generate page content
     * @return The created [Page] object
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
     * Creates a new page as a child of another page.
     * This method creates a subpage with a title and optional content blocks.
     * 
     * @param parentPage Reference to the parent page
     * @param title The title of the new page as a rich text list
     * @param icon Optional emoji or file to use as the page icon
     * @param cover Optional file to use as the page cover
     * @param content Optional list of blocks to add as page content
     * @return The created [Page] object
     * @throws NotionApiException if the parent page doesn't exist or the API request fails
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
     * Creates a new page as a child of another page using a block producer.
     * This overload allows for more dynamic block creation using a [BlockListProducer].
     * 
     * @param parentPage Reference to the parent page
     * @param title The title of the new page as a rich text list
     * @param icon Optional emoji or file to use as the page icon
     * @param cover Optional file to use as the page cover
     * @param content Block producer function to generate page content
     * @return The created [Page] object
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
     * Updates the properties of an existing page.
     * This method allows you to modify the page's icon, cover, and properties.
     * Note that page content cannot be updated using this method - use [KNotionBlocks] instead.
     * 
     * @param id The unique identifier of the page to update
     * @param icon Optional new emoji or file to use as the page icon
     * @param cover Optional new file to use as the page cover
     * @param properties New property values to set on the page
     * @return The updated [Page] object
     * @throws NotionApiException if the page doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/patch-page">Update page properties</a>
     */
    suspend fun updatePage(
        id: UuidString,
        icon: EmojiOrFile? = null,
        cover: File? = null,
        properties: PropertyValueList,
    ): Page

    /**
     * Archives or unarchives a page.
     * Archived pages are not deleted but are hidden from the Notion UI.
     * They can be unarchived later using this method with `archived = false`.
     * 
     * @param id The unique identifier of the page to archive/unarchive
     * @param archived Whether to archive (true) or unarchive (false) the page
     * @return The updated [Page] object
     * @throws NotionApiException if the page doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/patch-page#archive-delete-a-page">Archive a page</a>
     */
    suspend fun setPageArchived(id: UuidString, archived: Boolean): Page
}