package com.cesarwillymc.mbcgroup.data.sources.auth.remote

import com.cesarwillymc.mbcgroup.data.sources.auth.service.AuthService
import com.cesarwillymc.mbcgroup.util.state.getData
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.utils.MockkTest
import com.cesarwillymc.mbcgroup.utils.data.DataGenerator
import com.cesarwillymc.mbcgroup.utils.data.DomainGenerator
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRemoteDataSourceImplTest : MockkTest() {

    @RelaxedMockK
    lateinit var service: AuthService

    lateinit var authRemoteDataSource: AuthRemoteDataSource

    @Before
    fun setUp() {
        authRemoteDataSource = AuthRemoteDataSourceImpl(service)
    }

    @Test
    fun signIn() = runTest {
        coEvery { service.signIn(DataGenerator.authRequest) } returns DataGenerator.authResponse
        val response = authRemoteDataSource.signIn(DataGenerator.authRequest)
        assertTrue(response.isSuccess)
        assertEquals(
            response.getData().data.attributes.refreshToken,
            DomainGenerator.authResponse.refreshToken
        )
        assertEquals(
            response.getData().data.attributes.accessToken,
            DomainGenerator.authResponse.token
        )
        assertEquals(
            response.getData().data.attributes.tokenType,
            DomainGenerator.authResponse.tokenType
        )
    }

    @Test
    fun signInError() = runTest {
        coEvery { service.signIn(DataGenerator.authRequest) } throws Exception()
        val response = authRemoteDataSource.signIn(DataGenerator.authRequest)
        assertTrue(response.isError)
    }

    @Test
    fun logout() = runTest {
        coEvery { service.logout(DataGenerator.logoutRequest) } returns Unit
        val response = authRemoteDataSource.logout(DataGenerator.logoutRequest)
        assertTrue(response.isSuccess)
    }

    @Test
    fun logoutError() = runTest {
        coEvery { service.logout(DataGenerator.logoutRequest) } throws Exception()
        val response = authRemoteDataSource.logout(DataGenerator.logoutRequest)
        assertTrue(response.isError)
    }

    @Test
    fun forgotPassword() = runTest {
        coEvery { service.forgotPassword(DataGenerator.forgotRequest) } returns Unit
        val response = authRemoteDataSource.forgotPassword(DataGenerator.forgotRequest)
        assertTrue(response.isSuccess)
    }

    @Test
    fun forgotPasswordError() = runTest {
        coEvery { service.forgotPassword(DataGenerator.forgotRequest) } throws Exception()
        val response = authRemoteDataSource.forgotPassword(DataGenerator.forgotRequest)
        assertTrue(response.isError)
    }

    @Test
    fun refreshToken() = runTest {
        coEvery { service.refreshToken(DataGenerator.refreshTokenRequest) } returns DataGenerator.authResponse
        val response = authRemoteDataSource.refreshToken(DataGenerator.refreshTokenRequest)
        assertTrue(response.isSuccess)
        assertEquals(
            response.getData().data.attributes.refreshToken,
            DomainGenerator.authResponse.refreshToken
        )
        assertEquals(
            response.getData().data.attributes.accessToken,
            DomainGenerator.authResponse.token
        )
        assertEquals(
            response.getData().data.attributes.tokenType,
            DomainGenerator.authResponse.tokenType
        )
    }

    @Test
    fun refreshTokenError() = runTest {
        coEvery { service.refreshToken(DataGenerator.refreshTokenRequest) } throws Exception()
        val response = authRemoteDataSource.refreshToken(DataGenerator.refreshTokenRequest)
        assertTrue(response.isError)
    }
}
