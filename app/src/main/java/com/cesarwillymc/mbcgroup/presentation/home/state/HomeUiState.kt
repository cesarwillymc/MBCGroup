package com.cesarwillymc.mbcgroup.presentation.home.state

import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val data: SurveyList? = null
)