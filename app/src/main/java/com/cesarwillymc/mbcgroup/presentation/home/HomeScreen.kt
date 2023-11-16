package com.cesarwillymc.mbcgroup.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.presentation.home.component.HomeContent
import com.cesarwillymc.mbcgroup.presentation.home.component.HomeContentLoading
import com.cesarwillymc.mbcgroup.presentation.home.viewmodel.HomeViewModel
import com.cesarwillymc.mbcgroup.ui.components.CustomLottieMessage
import com.cesarwillymc.mbcgroup.ui.components.CustomSimpleScaffold

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToDetail: (SurveyItem) -> Unit
) {
    val homeUiState by homeViewModel.homeUiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when {
            homeUiState.isError -> CustomLottieMessage(
                lottie = R.raw.animation_error, title = stringResource(
                    id = R.string.lbl_error
                ), message = stringResource(id = R.string.desc_error)
            )

            homeUiState.isSuccess -> homeUiState.data?.let {
                HomeContent(
                    surveyList = it,
                    navigateToDetail = navigateToDetail
                )
            }

            else -> HomeContentLoading()
        }
    }

}
