package com.velkonost.knotion.internal.client

import com.velkonost.knotion.client.*
import com.velkonost.knotion.internal.client.databases.di.DatabasesModule
import com.velkonost.knotion.internal.network.di.networkModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules

internal class KNotionClientImpl(
    accessToken: String
) : KNotionClient, KoinComponent {

    init {
        setupDI(accessToken)
    }

    private fun setupDI(token: String) {
        loadKoinModules(
            listOf(
                networkModule(token),
                DatabasesModule
            )
        )
    }

    override val users: KNotionUsers by inject()
    override val databases: KNotionDatabases by inject()
    override val pages: KNotionPages by inject()
    override val blocks: KNotionBlocks by inject()
    override val search: KNotionSearch by inject()
}