package com.velkonost.knotion.model.oauth

interface OAuthCodeAndState {
    val code: String
    val state: String
}
