package com.velkonost.knotion.internal.client.search.di

import com.velkonost.knotion.client.KNotionSearch
import com.velkonost.knotion.internal.client.search.KNotionSearchImpl
import com.velkonost.knotion.internal.client.search.SearchService
import org.koin.dsl.module

internal val SearchModule = module {
    single { SearchService(get()) }
    single<KNotionSearch> { KNotionSearchImpl(get()) }
}