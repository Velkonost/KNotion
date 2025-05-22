package com.velkonost.knotion.internal.client.users.di

import com.velkonost.knotion.client.KNotionUsers
import com.velkonost.knotion.internal.client.users.KNotionUsersImpl
import com.velkonost.knotion.internal.client.users.UsersService
import org.koin.dsl.module

internal val UsersModule = module {
    single { UsersService(get()) }
    single<KNotionUsers> { KNotionUsersImpl(get()) }
}