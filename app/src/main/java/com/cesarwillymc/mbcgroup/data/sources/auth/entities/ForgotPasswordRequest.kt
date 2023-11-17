package com.cesarwillymc.mbcgroup.data.sources.auth.entities

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class ForgotPasswordRequest(
    val user: ForgotEmailRequest
)

data class ForgotEmailRequest(
    val email: String
)
