package com.cesarwillymc.mbcgroup.data.sources.auth.remote

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.mbcgroup.util.state.Result

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthRemoteDataSource {
    suspend fun signIn(
        authRequest: AuthRequest
    ): Result<AuthResponse>

    suspend fun logout(
        logoutRequest: LogoutRequest
    ): Result<Unit>
}
