package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import com.cesarwillymc.mbcgroup.ui.theme.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.ui.theme.TextColor
import com.cesarwillymc.mbcgroup.ui.theme.TextColorOpacity
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_30
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_80
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_90

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SurveyContentPager(
    surveyItem: SurveyItem,
    currentItem: Int,
    totalItems: Int,
    modifier: Modifier = Modifier,
    navigateDetail: (SurveyItem) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100)),
        modifier = modifier
    ) {

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.Small100)),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(totalItems) { iteration ->
                val color =
                    if (currentItem == iteration) Color.White else Color.Gray.copy(alpha = FRACTION_90)
                Box(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.FiveDp))
                        .clip(CircleShape)
                        .background(color)
                        .size(dimensionResource(id = R.dimen.Small150))
                )
            }
        }
        Text(text = surveyItem.title, style = Typography.titleMedium, color = TextColor)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = surveyItem.description,
                style = Typography.bodyLarge,
                color = TextColorOpacity
            )
            Image(
                painter = painterResource(id = R.drawable.action),
                contentDescription = "Icon go detail survey",
                modifier = Modifier
                    .clickable {
                        navigateDetail(surveyItem)
                    }
                    .padding(bottom = dimensionResource(id = R.dimen.Normal100))
            )
        }

    }
}