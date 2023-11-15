package com.cesarwillymc.mbcgroup.data.sources.auth

import com.cesarwillymc.mbcgroup.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.mbcgroup.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.mbcgroup.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.mbcgroup.data.sources.preferences.PreferencesDao
import com.cesarwillymc.mbcgroup.domain.usecase.entities.Auth
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.dataOrNull
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.util.state.map
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val resultMapper: AuthResultMapper,
    private val sharedDao: PreferencesDao
) : AuthDataSource {
    override suspend fun signIn(email: String, password: String): Result<Auth> {
        return remoteDataSource.signIn(AuthRequest(email, password))
            .map(resultMapper::fromResponseToDomain).also {
                if (it.isSuccess) {
                    sharedDao.saveToken(it.dataOrNull()?.token.orEmpty())
                }
            }
    }

    override suspend fun logout(): Result<Unit> {
        return remoteDataSource.logout(LogoutRequest(sharedDao.getToken.dataOrNull().orEmpty()))
            .also {
                if (it.isSuccess) {
                    sharedDao.cleanPreferences()
                }
            }
    }

    override suspend fun saveToken(token: String): Result<Unit> {
        return sharedDao.saveToken(token)
    }


    override suspend fun isLogged(): Result<Boolean> {
        return sharedDao.isLogged
    }
}
