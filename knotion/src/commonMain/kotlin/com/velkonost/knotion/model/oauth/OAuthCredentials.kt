package com.velkonost.knotion.model.oauth

data class OAuthCredentials(
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String,
)
