package com.cesarwillymc.mbcgroup.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.util.constants.DELAY_2500
import com.cesarwillymc.mbcgroup.util.constants.DELAY_3000
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_20
import com.cesarwillymc.mbcgroup.util.constants.TWO_F
import com.cesarwillymc.mbcgroup.util.constants.ZERO
import com.cesarwillymc.mbcgroup.util.constants.ZERO_F
import com.cesarwillymc.mbcgroup.util.extension.rememberResponsive
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    val offsetState = remember { androidx.compose.animation.core.Animatable(0f) }
    val alphaState = remember { androidx.compose.animation.core.Animatable(1f) }
    val responsive = rememberResponsive()
    val route by splashViewModel.startDestination.collectAsState()
    LaunchedEffect(true) {
        launch {
            offsetState.animateTo(
                targetValue = -responsive.heightR(FRACTION_20).value, // Adjust this value based on your layout
                animationSpec = tween(
                    durationMillis = DELAY_3000,
                    easing = {
                        OvershootInterpolator(TWO_F).getInterpolation(it)
                    }
                )
            )
        }
        launch {
            alphaState.animateTo(
                targetValue = ZERO_F,
                animationSpec = tween(durationMillis = DELAY_3000)
            )
        }
        delay(DELAY_2500)
        if (!route.isNullOrBlank()) {
            navigateTo(route.orEmpty())
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_backgroud),
            contentDescription = "Image Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Image Logo",
            modifier = Modifier
                .offset(y = offsetState.value.dp, x = ZERO.dp)
                .alpha(alpha = alphaState.value)
        )
    }
}
