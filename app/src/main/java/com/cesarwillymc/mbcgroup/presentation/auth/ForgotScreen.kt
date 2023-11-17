package com.cesarwillymc.mbcgroup.presentation.auth

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.presentation.auth.component.AuthScaffold
import com.cesarwillymc.mbcgroup.presentation.auth.component.ForgotContent
import com.cesarwillymc.mbcgroup.presentation.auth.viewmodel.ForgotViewModel
import com.cesarwillymc.mbcgroup.ui.components.CustomFullScreenLoading
import com.cesarwillymc.mbcgroup.ui.components.CustomSnackbar
import com.cesarwillymc.mbcgroup.ui.notification.createNotificationChannel
import com.cesarwillymc.mbcgroup.ui.notification.showNotification

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ForgotScreen(
    navigateUp: () -> Unit,
    forgotViewModel: ForgotViewModel
) {
    val authUiState by forgotViewModel.authUiState.collectAsState()
    val emailField = forgotViewModel.emailText
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    AuthScaffold(
        isIconsTopEnabled = true,
        onNavigateUp = navigateUp
    ) {
        ForgotContent(
            emailField = emailField,
            onContinueEmail = forgotViewModel::forgotPassword
        )
    }
    CustomSnackbar(snackbarHostState = snackbarHostState)
    CustomFullScreenLoading(authUiState.isLoading)
    LaunchedEffect(authUiState) {
        when {
            authUiState.isSuccess -> {
                context.createNotificationChannel()
                context.showNotification()
            }
            authUiState.isError -> {
                snackbarHostState.showSnackbar(
                    message = context.getString(R.string.desc_error_snackbar),
                    actionLabel = context.getString(R.string.lbl_error),
                    duration = SnackbarDuration.Long,
                    withDismissAction = true
                )
            }
        }
    }
}
