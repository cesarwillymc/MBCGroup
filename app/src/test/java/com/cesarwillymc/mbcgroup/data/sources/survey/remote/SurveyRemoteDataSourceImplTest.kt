package com.cesarwillymc.mbcgroup.data.sources.survey.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.mockserver.MockResponse
import com.apollographql.apollo3.mockserver.MockServer
import com.cesarwillymc.mbcgroup.util.state.getData
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import com.cesarwillymc.mbcgroup.utils.data.ApolloGeneratorTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRemoteDataSourceImplTest {
    @Test
    fun getSurveys() = runTest {
        // Create a mock server
        val mockServer = MockServer()
        val apolloClient = ApolloClient.Builder().serverUrl(mockServer.url()).build()
        val client = SurveyRemoteDataSourceImpl(apolloClient)

        // Enqueue HTTP responses
        mockServer.enqueue(
            MockResponse.Builder()
                .statusCode(200)
                .body(ApolloGeneratorTest.surveys)
                .delayMillis(1000L).build()
        )

        client.getSurveys().let {
            assertTrue(it.isSuccess)
            assertTrue(it.getData()?.surveys != null)
            assertEquals(3, it.getData()?.surveys?.edges?.size)
        }

        mockServer.stop()
    }

    @Test
    fun getSurveys500() = runTest {
        // Create a mock server
        val mockServer = MockServer()
        val apolloClient = ApolloClient.Builder().serverUrl(mockServer.url()).build()
        val client = SurveyRemoteDataSourceImpl(apolloClient)

        // Enqueue HTTP responses
        mockServer.enqueue(
            MockResponse.Builder()
                .statusCode(500)
                .body("Internal server error")
                .delayMillis(1000L).build()
        )

        client.getSurveys().let {
            assertTrue(it.isError)
        }

        mockServer.stop()
    }

    @Test
    fun getSurveysEmptyList() = runTest {
        // Create a mock server
        val mockServer = MockServer()
        val apolloClient = ApolloClient.Builder().serverUrl(mockServer.url()).build()
        val client = SurveyRemoteDataSourceImpl(apolloClient)

        // Enqueue HTTP responses
        mockServer.enqueue(
            MockResponse.Builder()
                .statusCode(200)
                .body(ApolloGeneratorTest.surveyNoFound)
                .delayMillis(1000L).build()
        )

        client.getSurveys().let {
            assertTrue(it.isSuccess)
            assertTrue(it.getData()?.surveys != null)
            assertEquals(0, it.getData()?.surveys?.edges?.size)
        }

        mockServer.stop()
    }
}
