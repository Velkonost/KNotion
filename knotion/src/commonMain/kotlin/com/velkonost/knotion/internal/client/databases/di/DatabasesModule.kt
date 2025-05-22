package com.velkonost.knotion.internal.client.databases.di

import com.velkonost.knotion.client.KNotionDatabases
import com.velkonost.knotion.internal.client.databases.DatabasesService
import com.velkonost.knotion.internal.client.databases.KNotionDatabasesImpl
import org.koin.dsl.module

internal val DatabasesModule = module {
    single { DatabasesService(get()) }
    single<KNotionDatabases> { KNotionDatabasesImpl(get()) }
}