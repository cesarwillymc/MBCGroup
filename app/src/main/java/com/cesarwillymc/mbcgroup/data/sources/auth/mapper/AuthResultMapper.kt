package com.cesarwillymc.mbcgroup.data.sources.auth.mapper

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.mbcgroup.domain.usecase.entities.Auth

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthResultMapper {
    fun fromResponseToDomain(info: AuthResponse): Auth
}
