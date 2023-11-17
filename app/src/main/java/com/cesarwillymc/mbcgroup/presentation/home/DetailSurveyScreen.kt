package com.cesarwillymc.mbcgroup.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.presentation.home.viewmodel.DetailSurveyViewModel
import com.cesarwillymc.mbcgroup.ui.components.CustomPrimaryButton
import com.cesarwillymc.mbcgroup.ui.theme.TextColor
import com.cesarwillymc.mbcgroup.ui.theme.TextColorOpacity
import com.cesarwillymc.mbcgroup.ui.theme.Typography
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_30

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun DetailSurveyScreen(
    detailSurveyViewModel: DetailSurveyViewModel,
    navigateUp: () -> Unit
) {
    val detailSurveyUiState by detailSurveyViewModel.detailUiState.collectAsState()
    Scaffold { paddingValues ->
        val data = detailSurveyUiState.data
        if (data != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Image(
                    painter = rememberImagePainter(data = data.coverImageUrl),
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(dimensionResource(id = R.dimen.Normal100))
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100))) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = stringResource(id = R.string.desc_back),
                        modifier = Modifier
                            .clickable(onClick = navigateUp),
                        tint = Color.White
                    )
                    Text(text = data.title, style = Typography.titleMedium, color = TextColor)

                    Text(
                        text = data.description,
                        style = Typography.bodyLarge,
                        color = TextColorOpacity
                    )
                }
                CustomPrimaryButton(
                    title = stringResource(R.string.lbl_start_survey),
                    modifier = Modifier.align(Alignment.BottomEnd)

                ) {
                }
            }
        }
    }
}
