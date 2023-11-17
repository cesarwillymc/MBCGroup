package com.cesarwillymc.mbcgroup.utils.data

import com.cesarwillymc.GetSurveysQuery
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.ForgotEmailRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.RefreshTokenRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.TokenAttributes
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.TokenData

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
object DataGenerator {
    val logoutRequest = LogoutRequest(
        token = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E"
    )
    val refreshTokenRequest = RefreshTokenRequest(
        refreshToken = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E"
    )
    val forgotRequest = ForgotPasswordRequest(
        user = ForgotEmailRequest(email = DomainGenerator.email)
    )
    val authRequest = AuthRequest(
        email = DomainGenerator.email,
        password = DomainGenerator.password
    )
    val authResponse = AuthResponse(
        TokenData(
            id = "12344566",
            type = "token",
            attributes = TokenAttributes(
                accessToken = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E",
                tokenType = "Bearer",
                expiresIn = 7200,
                refreshToken = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E",
                createdAt = 1312432131L
            )
        )
    )
    val surveys = GetSurveysQuery.Data(
        GetSurveysQuery.Surveys(
            edges = listOf(
                GetSurveysQuery.Edge(
                    GetSurveysQuery.Node(
                        id = "d5de6a8f8f5f1cfe51bc",
                        title = "Scarlett Bangko",
                        description = "We'd love ot hear from you!",
                        coverImageUrl = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
                    )
                ),
                GetSurveysQuery.Edge(
                    GetSurveysQuery.Node(
                        id = "ed1d4f0ff19a56073a14",
                        title = "ibis Bangkok Riverside",
                        description = "We'd love ot hear from you!",
                        coverImageUrl = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
                    )
                ),
                GetSurveysQuery.Edge(
                    GetSurveysQuery.Node(
                        id = "270130035d415c1d90bb",
                        title = "21 on Rajah",
                        description = "We'd love ot hear from you!",
                        coverImageUrl = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
                    )
                )
            ),
            pageInfo = GetSurveysQuery.PageInfo(true),
            totalCount = 20
        )
    )
}
