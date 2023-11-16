package com.cesarwillymc.mbcgroup.data.sources.auth.mapper

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.domain.usecase.entities.Auth
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthResultMapperImpl @Inject constructor() : AuthResultMapper {
    override fun fromResponseToDomain(info: AuthResponse): Auth {
        return Auth(
            info.data.attributes.accessToken,
            info.data.attributes.tokenType,
            info.data.attributes.refreshToken
        )
    }
}
