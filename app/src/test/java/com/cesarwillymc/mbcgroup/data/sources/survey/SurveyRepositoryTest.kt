package com.cesarwillymc.mbcgroup.data.sources.survey

import com.cesarwillymc.mbcgroup.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.mbcgroup.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.mbcgroup.util.state.Result
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
import java.lang.Exception

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRepositoryTest : MockkTest() {

    private lateinit var repository: SurveyRepository

    @RelaxedMockK
    lateinit var surveyRemoteDataSource: SurveyRemoteDataSource

    @RelaxedMockK
    lateinit var mapper: SurveyMapper

    @Before
    fun setUp() {
        repository = SurveyRepository(surveyRemoteDataSource, mapper = mapper)
    }

    @Test
    fun getSurveys() = runTest {
        coEvery { surveyRemoteDataSource.getSurveys() } returns Result.Success(
            DataGenerator.surveys
        )
        coEvery { mapper.dataSurveyToDomain(DataGenerator.surveys) } returns DomainGenerator.surveys
        val response = repository.getSurveys()

        assertTrue(response.isSuccess)
        response.getData().let {
            assertEquals(it.list.size, 3)
            assertEquals(it.hasNext, true)
        }
    }

    @Test
    fun getSurveysError() = runTest {
        coEvery { surveyRemoteDataSource.getSurveys() } returns Result.Error(
            Exception()
        )
        val response = repository.getSurveys()

        assertTrue(response.isError)
    }
}
