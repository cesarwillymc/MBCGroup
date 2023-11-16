package com.cesarwillymc.mbcgroup.presentation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.cesarwillymc.mbcgroup.presentation.auth.component.AuthScaffold
import com.cesarwillymc.mbcgroup.presentation.auth.component.ForgotContent
import com.cesarwillymc.mbcgroup.presentation.auth.viewmodel.ForgotViewModel
import com.cesarwillymc.mbcgroup.ui.components.CustomSnackbar

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
    val emailField = forgotViewModel.emailText
    val snackbarHostState = remember { SnackbarHostState() }
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
}
