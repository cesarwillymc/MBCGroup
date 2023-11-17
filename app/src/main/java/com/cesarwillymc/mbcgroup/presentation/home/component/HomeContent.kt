package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.rememberImagePainter
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_30

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    surveyList: SurveyList,
    navigateToDetail: (SurveyItem) -> Unit,
    openDrawer: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = {
            surveyList.list.size
        })
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Image(
                    painter = rememberImagePainter(data = surveyList.list[page].coverImageUrl),
                    contentDescription = "ImageCover",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black.copy(alpha = FRACTION_30))
                )
            }
        }
        SurveyContentPager(
            surveyItem = surveyList.list[pagerState.currentPage],
            currentItem = pagerState.currentPage,
            totalItems = surveyList.list.size,
            modifier = Modifier
                .align(
                    Alignment.BottomStart
                )
                .padding(dimensionResource(id = R.dimen.Normal100)),
            navigateDetail = navigateToDetail
        )
        ProfileCard(openDrawer = openDrawer)
    }
}
