package com.cesarwillymc.mbcgroup.data.sources.auth

import com.cesarwillymc.mbcgroup.domain.usecase.entities.Auth
import com.cesarwillymc.mbcgroup.util.state.Result

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthDataSource {
    suspend fun signIn(
        email: String,
        password: String
    ): Result<Auth>

    suspend fun saveToken(
        token: String
    ): Result<Unit>

    suspend fun logout(): Result<Unit>
    suspend fun forgotPassword(email: String): Result<Unit>

    suspend fun refreshToken(): Result<Auth>

    suspend fun isLogged(): Result<Boolean>
}
