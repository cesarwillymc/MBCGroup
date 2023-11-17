package com.cesarwillymc.mbcgroup.data.sources.auth.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class AuthResponse(
    val data: TokenData
)
data class TokenData(
    val id: String,
    val type: String,
    val attributes: TokenAttributes
)

data class TokenAttributes(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("created_at")
    val createdAt: Long
)
