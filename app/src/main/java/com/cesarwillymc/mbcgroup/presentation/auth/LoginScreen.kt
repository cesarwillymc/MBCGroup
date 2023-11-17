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
import com.cesarwillymc.mbcgroup.presentation.auth.component.SignInContent
import com.cesarwillymc.mbcgroup.presentation.auth.viewmodel.LoginViewModel
import com.cesarwillymc.mbcgroup.ui.components.CustomFullScreenLoading
import com.cesarwillymc.mbcgroup.ui.components.CustomSnackbar

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    navigateToForgot: () -> Unit,
    loginViewModel: LoginViewModel
) {
    val passwordField = loginViewModel.passwordText
    val emailText = loginViewModel.emailText
    val authUiState by loginViewModel.authUiState.collectAsState()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    CustomFullScreenLoading(authUiState.isLoading)
    AuthScaffold(
        isIconsTopEnabled = false
    ) {
        SignInContent(
            emailText = emailText,
            passwordField = passwordField,
            onContinue = loginViewModel::login,
            onClickForgotPassword = navigateToForgot
        )
    }
    CustomSnackbar(snackbarHostState = snackbarHostState)
    LaunchedEffect(authUiState) {
        if (authUiState.isError) {
            snackbarHostState.showSnackbar(
                message = authUiState.errorMessage
                    ?: context.getString(R.string.desc_error_snackbar),
                actionLabel = context.getString(R.string.lbl_error),
                duration = SnackbarDuration.Long,
                withDismissAction = true
            )
        }
        if (authUiState.isSuccess) {
            navigateToHome()
        }
    }
}
