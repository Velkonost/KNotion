package com.velkonost.knotion.internal.client.pages.di

import com.velkonost.knotion.client.KNotionPages
import com.velkonost.knotion.internal.client.pages.KNotionPagesImpl
import com.velkonost.knotion.internal.client.pages.PagesService
import org.koin.dsl.module

internal val PagesModule = module {
    single { PagesService(get()) }
    single<KNotionPages> { KNotionPagesImpl(get()) }
}