package com.velkonost.knotion.internal.client

import com.velkonost.knotion.client.*
import com.velkonost.knotion.internal.client.blocks.di.BlocksModule
import com.velkonost.knotion.internal.client.databases.di.DatabasesModule
import com.velkonost.knotion.internal.client.pages.di.PagesModule
import com.velkonost.knotion.internal.client.search.di.SearchModule
import com.velkonost.knotion.internal.client.users.di.UsersModule
import com.velkonost.knotion.internal.network.di.networkModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

internal class KNotionClientImpl(
    accessToken: String
) : KNotionClient, KoinComponent {

    init {
        setupDI(accessToken)
    }

    private fun setupDI(token: String) {
        startKoin {
            modules(
                listOf(
                    networkModule(token),
                    DatabasesModule,
                    PagesModule,
                    BlocksModule,
                    UsersModule,
                    SearchModule
                )
            )
        }
    }

    override val users: KNotionUsers by inject()
    override val databases: KNotionDatabases by inject()
    override val pages: KNotionPages by inject()
    override val blocks: KNotionBlocks by inject()
    override val search: KNotionSearch by inject()
}