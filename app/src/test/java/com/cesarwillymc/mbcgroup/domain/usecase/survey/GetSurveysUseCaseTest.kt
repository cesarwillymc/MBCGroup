package com.cesarwillymc.mbcgroup.domain.usecase.survey

import com.cesarwillymc.mbcgroup.data.sources.survey.SurveyDataSource
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
@OptIn(ExperimentalCoroutinesApi::class)
class GetSurveysUseCaseTest : MockkTest() {

    private lateinit var useCase: GetSurveysUseCase

    @RelaxedMockK
    lateinit var repository: SurveyDataSource

    @Before
    fun setUp() {
        useCase = GetSurveysUseCase(repository, UnconfinedTestDispatcher())
    }

    @Test
    fun execute() = runTest {
        coEvery { repository.getSurveys() } returns Result.Success(DomainGenerator.surveys)
        val response = useCase(Unit)
        assertTrue(response.isSuccess)
    }

    @Test
    fun executeError() = runTest {
        coEvery { repository.getSurveys() } returns Result.Error(Exception())
        val response = useCase(Unit)
        assertTrue(response.isError)
    }
}
