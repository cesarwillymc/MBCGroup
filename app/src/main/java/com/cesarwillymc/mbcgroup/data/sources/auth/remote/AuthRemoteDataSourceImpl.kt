package com.cesarwillymc.mbcgroup.data.sources.auth.remote

import com.cesarwillymc.mbcgroup.data.settings.network.util.BaseRemoteDataSource
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.RefreshTokenRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.service.AuthService
import com.cesarwillymc.mbcgroup.util.state.Result
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthRemoteDataSource,
    BaseRemoteDataSource() {
    override suspend fun signIn(authRequest: AuthRequest): Result<AuthResponse> = getResult {
        authService.signIn(authRequest)
    }

    override suspend fun logout(logoutRequest: LogoutRequest): Result<Unit> = getResult {
        authService.logout(logoutRequest)
    }

    override suspend fun refreshToken(refresh: RefreshTokenRequest): Result<AuthResponse> =
        getResult {
            authService.refreshToken(refresh)
        }
}
