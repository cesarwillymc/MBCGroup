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
class ForgotUseCaseTest : MockkTest() {

    private lateinit var useCase: ForgotUseCase

    @RelaxedMockK
    lateinit var repository: AuthDataSource

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        useCase = ForgotUseCase(repository, UnconfinedTestDispatcher())
    }

    @Test
    fun execute() = runTest {
        coEvery { repository.forgotPassword(DomainGenerator.email) } returns Result.Success(Unit)
        val response = useCase(DomainGenerator.email)
        assertTrue(response.isSuccess)
    }

    @Test
    fun executeError() = runTest {
        coEvery { repository.forgotPassword(DomainGenerator.email) } returns Result.Error(Exception())
        val response = useCase(DomainGenerator.email)
        assertTrue(response.isError)
    }
}
