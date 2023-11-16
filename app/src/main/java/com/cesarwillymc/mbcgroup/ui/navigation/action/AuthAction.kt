package com.cesarwillymc.mbcgroup.ui.navigation.action

import androidx.navigation.NavHostController
import com.cesarwillymc.mbcgroup.ui.navigation.route.AuthRoute

class AuthAction(navController: NavHostController) {

    val navigateToAuth: () -> Unit = {
        navController.navigate(AuthRoute.Auth.path) {
            popUpTo(AuthRoute.Auth.path) { inclusive = true }
        }
    }
    val navigateToSignIn: (String) -> Unit = {
        navController.navigate(
            AuthRoute.SignIn.path.replace(
                "{${AuthRoute.EMAIL_KEY}}",
                it
            )
        )
    }
    val navigateToForgot: () -> Unit = {
        navController.navigate(AuthRoute.Forgot.path)
    }
}
