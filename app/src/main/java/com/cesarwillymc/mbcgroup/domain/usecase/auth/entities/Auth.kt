package com.cesarwillymc.mbcgroup.domain.usecase.auth.entities

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class Auth(
    val token: String,
    val tokenType: String,
    val refreshToken: String
)
