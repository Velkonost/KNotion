package com.velkonost.knotion.internal.client.blocks.di

import com.velkonost.knotion.client.KNotionBlocks
import com.velkonost.knotion.internal.client.blocks.BlocksService
import com.velkonost.knotion.internal.client.blocks.KNotionBlocksImpl
import org.koin.dsl.module

internal val BlocksModule = module{
    single { BlocksService(get()) }
    single<KNotionBlocks> { KNotionBlocksImpl(get()) }
}