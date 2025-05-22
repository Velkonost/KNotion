package com.velkonost.knotion.client

import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.BlockListProducer
import com.velkonost.knotion.model.page.block.MutableBlockList
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage

interface KNotionBlocks {
    /**
     * Retrieve children blocks of the specified object.
     *
     * Note: this will *not* retrieve the children blocks (if any). Blocks that don't have children will have their
     * [Block.children] property set to `null`, whereas blocks that do have children will have it set to an empty list.
     *
     * If you need to retrieve the children blocks recursively refer to the [getAllBlockListRecursively] method instead.
     *
     * @see <a href="https://developers.notion.com/reference/get-block-children">Retrieve block children</a>
     */
    suspend fun getBlockList(parentId: UuidString, pagination: Pagination = Pagination()): ResultPage<Block>

    /**
     * Retrieve all children blocks (including all the pages) of the specified object, and including all their children,
     * recursively.
     *
     * **Caution:** be aware that this will potentially make many network calls (depending on the size of the block list you
     * are retrieving).
     */
    suspend fun getAllBlockListRecursively(parentId: UuidString): List<Block>

    /**
     * Append blocks to the children of the specified object.
     * @see <a href="https://developers.notion.com/reference/patch-block-children">Append block children</a>
     */
    suspend fun appendBlockList(parentId: UuidString, blocks: MutableBlockList)

    /**
     * Append blocks to the children of the specified object.
     * @see <a href="https://developers.notion.com/reference/patch-block-children">Append block children</a>
     */
    suspend fun appendBlockList(parentId: UuidString, blocks: BlockListProducer)

    /**
     * Retrieve a block.
     *
     * Note:
     * - when [retrieveChildrenRecursively] is set to `false`, this will *not* retrieve the children blocks (if any).
     * Blocks that don't have children will have their [Block.children] property set to `null`,
     * whereas blocks that do have children will have it set to an empty list.
     *- when [retrieveChildrenRecursively] is set to `true`, all the block's children, will be retrieved, recursively.
     * **Caution:** be aware that this will potentially make many network calls (depending on the size of the children list you
     * are retrieving).
     *
     * @see <a href="https://developers.notion.com/reference/retrieve-a-block">Retrieve a block</a>
     */
    suspend fun getBlock(id: UuidString, retrieveChildrenRecursively: Boolean = false): Block

    /**
     * Update the contents of a block.
     *
     * Note:
     * - you cannot change a block's type, but only its contents.
     * This method will throw an exception if a [block] of a different type is passed.
     * - this will *not* retrieve the children blocks (if any).
     * Blocks that don't have children will have their [Block.children] property set to `null`,
     * whereas blocks that do have children will have it set to an empty list.
     *
     * @see <a href="https://developers.notion.com/reference/update-a-block">Update a block</a>
     */
    suspend fun updateBlock(id: UuidString, block: Block): Block
}