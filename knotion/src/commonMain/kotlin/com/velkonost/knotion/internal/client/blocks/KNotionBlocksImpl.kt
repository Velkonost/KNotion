package com.velkonost.knotion.internal.client.blocks

import com.velkonost.knotion.client.KNotionBlocks
import com.velkonost.knotion.extension.UuidString
import com.velkonost.knotion.internal.api.model.database.toModel
import com.velkonost.knotion.internal.api.model.database.toPaginationModel
import com.velkonost.knotion.internal.api.model.page.block.request.AppendBlockRequest
import com.velkonost.knotion.internal.api.model.page.block.request.UpdateBlockRequest
import com.velkonost.knotion.internal.api.model.page.block.toModel
import com.velkonost.knotion.internal.model.page.block.MutableBlock
import com.velkonost.knotion.model.page.block.Block
import com.velkonost.knotion.model.page.block.BlockListProducer
import com.velkonost.knotion.model.page.block.MutableBlockList
import com.velkonost.knotion.model.page.block.invoke
import com.velkonost.knotion.model.pagination.Pagination
import com.velkonost.knotion.model.pagination.ResultPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlin.coroutines.coroutineContext

internal class KNotionBlocksImpl(
    private val service: BlocksService
) : KNotionBlocks {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    override suspend fun getBlockList(parentId: UuidString, pagination: Pagination): ResultPage<Block> {
        val response = service.getBlockList(parentId, pagination.startCursor)
        return ResultPage(
            results = response.results.map { it.toModel() },
            nextPagination = response.nextCursor?.toPaginationModel()
        )
    }

    override suspend fun getAllBlockListRecursively(parentId: UuidString): List<Block> {
        val results = mutableListOf<Block>()
        var nextPagination: Pagination? = Pagination()
        while (nextPagination != null) {
            val blockResultPage = service.getBlockList(parentId, nextPagination.startCursor).toModel().run {
                ResultPage(
                    results = this.results.map { it.toModel() },
                    nextPagination = this.nextPagination
                )
            }
            getChildrenRecursively(blockResultPage)
            results += blockResultPage.results
            nextPagination = blockResultPage.nextPagination
        }
        return results
    }

    private suspend fun getChildrenRecursively(blockResultPage: ResultPage<Block>) {
        val job = Job()
        for (block in blockResultPage.results) {
            if (block is MutableBlock && block.children?.isEmpty() == true) {
                @Suppress("DeferredResultUnused")
                coroutineScope.async(coroutineContext + job) {
                    val childrenResultPage = getAllBlockListRecursively(block.id)
                    block.children = childrenResultPage
                }
            }
        }
        job.children.forEach { it.join() }
    }

    override suspend fun appendBlockList(parentId: UuidString, blocks: MutableBlockList) {
        service.appendBlockList(parentId, AppendBlockRequest(blocks))
    }

    override suspend fun appendBlockList(parentId: UuidString, blocks: BlockListProducer) {
        appendBlockList(parentId, blocks.invoke() ?: MutableBlockList())
    }

    override suspend fun getBlock(id: UuidString, retrieveChildrenRecursively: Boolean): Block {
        val block = service.getBlock(id).toModel()
        if (retrieveChildrenRecursively && block.children != null) {
            val children = getAllBlockListRecursively(id)
            (block as MutableBlock).children = children
        }
        return block
    }

    override suspend fun updateBlock(id: UuidString, block: Block): Block {
        return service.updateBlock(id, UpdateBlockRequest(block)).toModel()
    }
}