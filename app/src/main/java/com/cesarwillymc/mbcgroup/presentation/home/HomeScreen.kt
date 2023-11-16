package com.cesarwillymc.mbcgroup.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.cesarwillymc.mbcgroup.presentation.home.viewmodel.HomeViewModel
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
    navigateAuthScreen: () -> Unit
) {
    val authUiState by homeViewModel.authUiState.collectAsState()
    CustomSimpleScaffold(
        title = {
            Text(
                text = stringResource(id = R.string.lbl_home),
                style = MaterialTheme.typography.titleMedium
            )
        },
        enableNavigationIcon = false,
        actions = {
            IconButton(
                onClick = homeViewModel::logout,
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.Small150))
                    .clip(CircleShape)
                    .size(dimensionResource(id = R.dimen.Large100))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logout),
                    contentDescription = stringResource(R.string.lbl_onclick_logout)
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.Normal100))
        ) {
            Text(
                text = stringResource(R.string.desc_description),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
    LaunchedEffect(authUiState) {
        if (authUiState.isSuccess) {
            navigateAuthScreen()
        }
    }
}
