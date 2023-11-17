package com.cesarwillymc.mbcgroup.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cesarwillymc.mbcgroup.presentation.auth.ForgotScreen
import com.cesarwillymc.mbcgroup.presentation.auth.LoginScreen
import com.cesarwillymc.mbcgroup.presentation.home.DetailSurveyScreen
import com.cesarwillymc.mbcgroup.presentation.home.HomeScreen
import com.cesarwillymc.mbcgroup.presentation.splash.SplashScreen
import com.cesarwillymc.mbcgroup.ui.navigation.action.AuthAction
import com.cesarwillymc.mbcgroup.ui.navigation.action.MainAction
import com.cesarwillymc.mbcgroup.ui.navigation.deeplink.generateDeepLinks
import com.cesarwillymc.mbcgroup.ui.navigation.route.AuthRoute
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute

@Composable
fun CustomNavGraph(
    navController: NavHostController
) {
    val mainActions = remember(navController) { MainAction(navController) }
    val authActions = remember(navController) { AuthAction(navController) }
    NavHost(
        navController = navController,
        startDestination = AuthRoute.Splash.path
    ) {
        composable(
            route = AuthRoute.Splash.path,
            deepLinks = AuthRoute.Splash.path.generateDeepLinks()
        ) {
            SplashScreen(
                navigateTo = mainActions.navigateToInclusive
            )
        }
        navigation(startDestination = AuthRoute.SignIn.path, route = AuthRoute.Auth.path) {
            composable(
                route = AuthRoute.SignIn.path,
                deepLinks = AuthRoute.SignIn.path.generateDeepLinks()
            ) {
                LoginScreen(
                    navigateToHome = mainActions.navigateToMain,
                    navigateToForgot = authActions.navigateToForgot,
                    loginViewModel = hiltViewModel()
                )
            }
            composable(
                route = AuthRoute.Forgot.path,
                deepLinks = AuthRoute.Forgot.path.generateDeepLinks()
            ) {
                ForgotScreen(
                    navigateUp = mainActions.navigateUp,
                    forgotViewModel = hiltViewModel()
                )
            }
        }

        composable(
            route = MainRoute.Main.path,
            deepLinks = MainRoute.Main.path.generateDeepLinks()
        ) {
            HomeScreen(
                homeViewModel = hiltViewModel(),
                navigateToDetail = mainActions.navigateToDetail,
                navigateToAuth = authActions.navigateToAuth
            )
        }
        composable(
            route = MainRoute.Detail.path,
            deepLinks = MainRoute.Detail.path.generateDeepLinks()
        ) {
            DetailSurveyScreen(
                detailSurveyViewModel = hiltViewModel(),
                navigateUp = mainActions.navigateUp
            )
        }
    }
}
