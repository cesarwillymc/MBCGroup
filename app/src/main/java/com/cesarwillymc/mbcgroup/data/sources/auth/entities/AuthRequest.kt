package com.cesarwillymc.mbcgroup.data.sources.auth.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class AuthRequest(
    val email: String,
    val password: String,
    @SerializedName("grant_type")
    val grantType: String = "password"
)
