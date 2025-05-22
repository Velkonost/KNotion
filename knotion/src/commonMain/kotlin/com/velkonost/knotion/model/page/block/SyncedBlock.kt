package com.velkonost.knotion.model.page.block

import com.velkonost.knotion.extension.UuidString

/**
 * See [Reference](https://developers.notion.com/reference/block).
 */
interface SyncedBlock : Block {
    val syncedFrom: UuidString?
}
