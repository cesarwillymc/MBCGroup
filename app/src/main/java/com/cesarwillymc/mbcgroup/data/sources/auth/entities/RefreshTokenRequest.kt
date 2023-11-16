package com.cesarwillymc.mbcgroup.data.sources.auth.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class RefreshTokenRequest(
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("grant_type")
    val grantType: String = "refresh_token"
)
