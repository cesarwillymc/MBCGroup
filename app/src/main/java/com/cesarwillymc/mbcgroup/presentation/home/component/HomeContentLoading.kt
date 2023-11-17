package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.ui.components.TextShimmer
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_10
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_30
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_40
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_50
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_70
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_90
import com.cesarwillymc.mbcgroup.util.extension.rememberResponsive

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
@SuppressWarnings("LongMethod")
fun HomeContentLoading() {
    val responsive = rememberResponsive()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Black)
            .padding(dimensionResource(id = R.dimen.Normal100))
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Small50))) {
                TextShimmer(
                    modifier = Modifier.size(
                        width = responsive.withR(FRACTION_50),
                        height = dimensionResource(id = R.dimen.Normal100)
                    )
                )
                TextShimmer(
                    modifier = Modifier.size(
                        width = responsive.withR(FRACTION_30),
                        height = dimensionResource(id = R.dimen.Normal100)
                    )
                )
            }
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Small100)))

            TextShimmer(
                modifier = Modifier.size(dimensionResource(id = R.dimen.Large175))
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.Normal100)
            )
        ) {
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_10),
                    height = dimensionResource(id = R.dimen.Normal100)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_70),
                    height = dimensionResource(id = R.dimen.Normal100)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_40),
                    height = dimensionResource(id = R.dimen.Normal100)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_90),
                    height = dimensionResource(id = R.dimen.Normal100)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_30),
                    height = dimensionResource(id = R.dimen.Normal100)
                )
            )
        }
    }
}
