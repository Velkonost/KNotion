package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.BlockListProducer
import com.velkonost.knotion.model.page.block.MutableBlockList
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage

/**
 * Interface for managing Notion blocks through the Notion API.
 * This interface provides methods to create, retrieve, update, and manage blocks within pages and other blocks.
 * Blocks are the fundamental content units in Notion, including paragraphs, lists, to-do items, and more.
 * 
 * Example usage:
 * ```
 * // Retrieve blocks from a page
 * val blocks = client.blocks.getBlockList("page-id")
 * 
 * // Append new blocks to a page
 * client.blocks.appendBlockList("page-id") {
 *     paragraph("This is a new paragraph")
 *     toDo("Complete this task", checked = false)
 * }
 * ```
 */
interface KNotionBlocks {
    /**
     * Retrieves the immediate children blocks of a specified parent object (page or block).
     * This method only retrieves the direct children and does not fetch nested blocks.
     * 
     * Note: This will not retrieve nested children blocks. Blocks that can have children
     * will have their [Block.children] property set to an empty list, while blocks that
     * cannot have children will have it set to null. Use [getAllBlockListRecursively] to
     * fetch all nested blocks.
     * 
     * @param parentId The unique identifier of the parent page or block
     * @param pagination Optional pagination parameters to control the number of results
     * @return A [ResultPage] containing a list of [Block] objects and pagination information
     * @throws NotionApiException if the parent object doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/get-block-children">Retrieve block children</a>
     */
    suspend fun getBlockList(parentId: UuidString, pagination: Pagination = Pagination()): ResultPage<Block>

    /**
     * Retrieves all blocks within a parent object, including all nested children blocks recursively.
     * This method will fetch the complete block tree structure.
     * 
     * **Caution:** This method makes multiple API calls to fetch all nested blocks,
     * which can be slow for pages with many blocks. Use with care for large pages.
     * 
     * @param parentId The unique identifier of the parent page or block
     * @return A flat list of all [Block] objects, including nested children
     * @throws NotionApiException if the parent object doesn't exist or the API request fails
     */
    suspend fun getAllBlockListRecursively(parentId: UuidString): List<Block>

    /**
     * Appends new blocks as children to a specified parent object (page or block).
     * This method allows you to add multiple blocks at once using a [MutableBlockList].
     * 
     * @param parentId The unique identifier of the parent page or block
     * @param blocks The list of blocks to append
     * @throws NotionApiException if the parent object doesn't exist, the blocks are invalid,
     *         or the API request fails
     * @see <a href="https://developers.notion.com/reference/patch-block-children">Append block children</a>
     */
    suspend fun appendBlockList(parentId: UuidString, blocks: MutableBlockList)

    /**
     * Appends new blocks as children to a specified parent object using a block producer.
     * This overload allows for more dynamic block creation using a [BlockListProducer].
     * 
     * @param parentId The unique identifier of the parent page or block
     * @param blocks Block producer function to generate the blocks to append
     * @throws NotionApiException if the parent object doesn't exist, the blocks are invalid,
     *         or the API request fails
     * @see <a href="https://developers.notion.com/reference/patch-block-children">Append block children</a>
     */
    suspend fun appendBlockList(parentId: UuidString, blocks: BlockListProducer)

    /**
     * Retrieves a specific block by its ID.
     * 
     * Note:
     * - When [retrieveChildrenRecursively] is false, this will not retrieve nested children blocks.
     *   Blocks that can have children will have their [Block.children] property set to an empty list,
     *   while blocks that cannot have children will have it set to null.
     * - When [retrieveChildrenRecursively] is true, all nested children blocks will be retrieved.
     *   **Caution:** This can result in many API calls for blocks with many children.
     * 
     * @param id The unique identifier of the block to retrieve
     * @param retrieveChildrenRecursively Whether to fetch all nested children blocks
     * @return The requested [Block] object
     * @throws NotionApiException if the block doesn't exist or the API request fails
     * @see <a href="https://developers.notion.com/reference/retrieve-a-block">Retrieve a block</a>
     */
    suspend fun getBlock(id: UuidString, retrieveChildrenRecursively: Boolean = false): Block

    /**
     * Updates the content of an existing block.
     * 
     * Note:
     * - You cannot change a block's type (e.g., from paragraph to to-do), only its content.
     *   This method will throw an exception if a block of a different type is provided.
     * - This method does not retrieve or update children blocks. Blocks that can have children
     *   will have their [Block.children] property set to an empty list, while blocks that
     *   cannot have children will have it set to null.
     * 
     * @param id The unique identifier of the block to update
     * @param block The updated block content (must be the same type as the original block)
     * @return The updated [Block] object
     * @throws NotionApiException if the block doesn't exist, the block type doesn't match,
     *         or the API request fails
     * @see <a href="https://developers.notion.com/reference/update-a-block">Update a block</a>
     */
    suspend fun updateBlock(id: UuidString, block: Block): Block
}