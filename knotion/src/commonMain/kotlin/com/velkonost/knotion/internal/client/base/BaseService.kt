package com.velkonost.knotion.internal.client.base

import kotlin.jvm.JvmStatic

internal interface BaseService {
    val path: String
    companion object {
        @JvmStatic
        protected const val START_CURSOR = "start_cursor"
    }
}