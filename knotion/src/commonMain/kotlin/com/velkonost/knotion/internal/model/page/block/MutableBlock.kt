package com.velkonost.knotion.internal.model.page.block

import com.velkonost.knotion.model.page.block.Block

internal interface MutableBlock {
    var children: List<Block>?
}
