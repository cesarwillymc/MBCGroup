package com.cesarwillymc.mbcgroup.data.sources.auth.service

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
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

    private companion object {
        const val LOGIN = "api/v1/oauth/token"
        const val LOGOUT = "api/v1/oauth/revoke"
    }
}
