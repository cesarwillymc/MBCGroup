package com.cesarwillymc.mbcgroup.domain.usecase.auth

import com.cesarwillymc.mbcgroup.data.sources.auth.AuthDataSource
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.utils.MockkTest
import com.cesarwillymc.mbcgroup.utils.data.DomainGenerator
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.lang.Exception

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SignInUseCaseTest : MockkTest() {

    private lateinit var useCase: SignInUseCase

    @RelaxedMockK
    lateinit var repository: AuthDataSource

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        useCase = SignInUseCase(repository, UnconfinedTestDispatcher())
    }

    @Test
    fun execute() = runTest {
        coEvery {
            repository.signIn(
                DomainGenerator.email,
                DomainGenerator.password
            )
        } returns Result.Success(DomainGenerator.authResponse)
        val response = useCase(DomainGenerator.authRequest)
        assertTrue(response.isSuccess)
    }

    @Test
    fun executeError() = runTest {
        coEvery {
            repository.signIn(
                DomainGenerator.email,
                DomainGenerator.password
            )
        } returns Result.Error(Exception())
        val response = useCase(DomainGenerator.authRequest)
        assertTrue(response.isError)
    }
}
