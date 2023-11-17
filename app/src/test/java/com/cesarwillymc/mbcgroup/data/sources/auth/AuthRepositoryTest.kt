package com.cesarwillymc.mbcgroup.data.sources.auth

import com.cesarwillymc.mbcgroup.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.mbcgroup.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.mbcgroup.data.sources.preferences.PreferencesDao
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.dataOrNull
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.utils.MockkTest
import com.cesarwillymc.mbcgroup.utils.data.DataGenerator
import com.cesarwillymc.mbcgroup.utils.data.DomainGenerator
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRepositoryTest : MockkTest() {

    lateinit var authRepository: AuthDataSource

    @RelaxedMockK
    lateinit var remoteDataSource: AuthRemoteDataSource

    @RelaxedMockK
    lateinit var resultMapper: AuthResultMapper

    @RelaxedMockK
    lateinit var sharedDao: PreferencesDao

    @Before
    fun setUp() {
        authRepository = AuthRepository(remoteDataSource, resultMapper, sharedDao)
    }

    @Test
    fun signIn() = runTest {
        coEvery { remoteDataSource.signIn(DataGenerator.authRequest) } returns Result.Success(
            DataGenerator.authResponse
        )
        coEvery { resultMapper.fromResponseToDomain(DataGenerator.authResponse) } returns (DomainGenerator.authResponse)

        coEvery { sharedDao.saveToken(DomainGenerator.authResponse.token) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveRefreshToken(DomainGenerator.authResponse.refreshToken) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveTokenType(DomainGenerator.authResponse.tokenType) } returns Result.Success(
            Unit
        )
        val response = authRepository.signIn(DomainGenerator.email, DomainGenerator.password)
        Assert.assertTrue(response.isSuccess)
        Assert.assertFalse(response.dataOrNull()?.refreshToken.isNullOrBlank())
    }

    @Test
    fun signInError() = runTest {
        coEvery { remoteDataSource.signIn(DataGenerator.authRequest) } returns Result.Error(
            Exception()
        )
        coEvery { sharedDao.saveToken(DomainGenerator.authResponse.token) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveRefreshToken(DomainGenerator.authResponse.refreshToken) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveTokenType(DomainGenerator.authResponse.tokenType) } returns Result.Success(
            Unit
        )
        val response = authRepository.signIn(DomainGenerator.email, DomainGenerator.password)
        Assert.assertTrue(response.isError)
    }

    @Test
    fun logout() = runTest {
        coEvery { remoteDataSource.logout(DataGenerator.logoutRequest) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.getToken } returns Result.Success(DomainGenerator.authResponse.token)
        coEvery { sharedDao.cleanPreferences() } returns Result.Success(Unit)
        val response = authRepository.logout()
        Assert.assertTrue(response.isSuccess)
    }

    @Test
    fun logoutError() = runTest {
        coEvery { remoteDataSource.logout(DataGenerator.logoutRequest) } returns Result.Error(
            Exception()
        )
        coEvery { sharedDao.cleanPreferences() } returns Result.Success(Unit)

        val response = authRepository.logout()
        Assert.assertTrue(response.isError)
    }

    @Test
    fun forgotPasswordError() = runTest {
        coEvery { remoteDataSource.forgotPassword(DataGenerator.forgotRequest) } returns Result.Error(
            Exception()
        )
        val response = authRepository.forgotPassword(DomainGenerator.email)
        Assert.assertTrue(response.isError)
    }

    @Test
    fun forgotPassword() = runTest {
        coEvery { remoteDataSource.forgotPassword(DataGenerator.forgotRequest) } returns Result.Success(
            Unit
        )
        val response = authRepository.forgotPassword(DomainGenerator.email)
        Assert.assertTrue(response.isSuccess)
    }

    @Test
    fun refreshToken() = runTest {
        coEvery { remoteDataSource.refreshToken(DataGenerator.refreshTokenRequest) } returns Result.Success(
            DataGenerator.authResponse
        )
        coEvery { sharedDao.getRefreshToken } returns Result.Success(DomainGenerator.authResponse.refreshToken)
        coEvery { resultMapper.fromResponseToDomain(DataGenerator.authResponse) } returns (DomainGenerator.authResponse)
        coEvery { sharedDao.saveToken(DomainGenerator.authResponse.token) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveRefreshToken(DomainGenerator.authResponse.refreshToken) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveTokenType(DomainGenerator.authResponse.tokenType) } returns Result.Success(
            Unit
        )
        val response = authRepository.refreshToken()
        Assert.assertTrue(response.isSuccess)
        Assert.assertFalse(response.dataOrNull()?.refreshToken.isNullOrBlank())
    }

    @Test
    fun refreshTokenError() = runTest {
        coEvery { remoteDataSource.refreshToken(DataGenerator.refreshTokenRequest) } returns Result.Error(
            Exception()
        )
        coEvery { sharedDao.saveToken(DomainGenerator.authResponse.token) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveRefreshToken(DomainGenerator.authResponse.refreshToken) } returns Result.Success(
            Unit
        )
        coEvery { sharedDao.saveTokenType(DomainGenerator.authResponse.tokenType) } returns Result.Success(
            Unit
        )
        val response = authRepository.refreshToken()
        Assert.assertTrue(response.isError)
    }

    @Test
    fun isLogged() = runTest {
        coEvery { sharedDao.isLogged } returns Result.Success(true)
        val response = authRepository.isLogged()
        Assert.assertTrue(response.isSuccess)
    }

    @Test
    fun isLoggedError() = runTest {
        coEvery { sharedDao.isLogged } returns Result.Error(Exception())
        val response = authRepository.isLogged()
        Assert.assertTrue(response.isError)
    }
}
