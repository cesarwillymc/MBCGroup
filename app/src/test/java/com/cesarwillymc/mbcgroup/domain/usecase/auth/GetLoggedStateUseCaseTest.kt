package com.cesarwillymc.mbcgroup.domain.usecase.auth

import com.cesarwillymc.mbcgroup.data.sources.auth.AuthDataSource
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.utils.MockkTest
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
class GetLoggedStateUseCaseTest : MockkTest() {

    private lateinit var useCase: GetLoggedStateUseCase

    @RelaxedMockK
    lateinit var repository: AuthDataSource

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        useCase = GetLoggedStateUseCase(repository, UnconfinedTestDispatcher())
    }

    @Test
    fun execute() = runTest {
        coEvery { repository.isLogged() } returns Result.Success(true)
        val response = useCase(Unit)
        assertTrue(response.isSuccess)
    }

    @Test
    fun executeError() = runTest {
        coEvery { repository.isLogged() } returns Result.Error(Exception())
        val response = useCase(Unit)
        assertTrue(response.isError)
    }
}
