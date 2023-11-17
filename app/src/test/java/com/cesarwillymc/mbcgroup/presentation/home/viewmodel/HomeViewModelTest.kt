package com.cesarwillymc.mbcgroup.presentation.home.viewmodel

import app.cash.turbine.test
import com.cesarwillymc.mbcgroup.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.mbcgroup.domain.usecase.survey.GetSurveysUseCase
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.utils.BaseViewModelTest
import com.cesarwillymc.mbcgroup.utils.data.DomainGenerator
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
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
class HomeViewModelTest : BaseViewModelTest() {

    lateinit var homeViewModel: HomeViewModel

    @RelaxedMockK
    lateinit var logoutUseCase: LogoutUseCase

    @RelaxedMockK
    lateinit var getSurveys: GetSurveysUseCase

    @Before
    fun setUp() {
        coEvery { getSurveys(Unit) } returns Result.Success(DomainGenerator.surveys)
        homeViewModel = HomeViewModel(logoutUseCase, getSurveys)
    }

    @Test
    fun logout() = runTest {
        coEvery { logoutUseCase(Unit) } returns Result.Success(Unit)
        homeViewModel.logout()
        homeViewModel.authUiState.test {
            val auth = awaitItem()
            Assert.assertTrue(auth.isSuccess)
        }
    }

    @Test
    fun logoutError() = runTest {
        coEvery { logoutUseCase(Unit) } returns Result.Error(Exception())
        homeViewModel.logout()
        homeViewModel.authUiState.test {
            val auth = awaitItem()
            Assert.assertTrue(auth.isError)
        }
    }
}
