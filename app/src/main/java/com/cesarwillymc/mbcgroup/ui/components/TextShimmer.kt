package com.cesarwillymc.mbcgroup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.valentinilk.shimmer.shimmer

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun TextShimmer(
    modifier: Modifier
) {
    Box(
        modifier = Modifier.clip(CircleShape).shimmer()
    ) {
        Box(
            modifier = modifier
                .background(
                    Color.White
                )
        ) {
            // Todo
        }
    }
}
