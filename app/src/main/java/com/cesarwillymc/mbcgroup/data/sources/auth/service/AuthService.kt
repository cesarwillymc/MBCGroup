package com.cesarwillymc.mbcgroup.data.sources.auth.service

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.RefreshTokenRequest
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthService {
    @POST(LOGIN)
    suspend fun signIn(
        @Body body: AuthRequest
    ): AuthResponse

    @POST(LOGOUT)
    suspend fun logout(
        @Body body: LogoutRequest
    )

    @POST(FORGOT)
    suspend fun forgotPassword(
        @Body body: ForgotPasswordRequest
    )

    @POST(REFRESH)
    suspend fun refreshToken(
        @Body body: RefreshTokenRequest
    ): AuthResponse

    private companion object {
        const val LOGIN = "api/v1/oauth/token"
        const val LOGOUT = "api/v1/oauth/revoke"
        const val REFRESH = "api/v1/oauth/token"
        const val FORGOT = "api/v1/passwords"
    }
}
