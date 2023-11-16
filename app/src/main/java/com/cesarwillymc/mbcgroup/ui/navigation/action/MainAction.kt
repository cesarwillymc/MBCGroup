package com.cesarwillymc.mbcgroup.ui.navigation.action

import androidx.navigation.NavHostController
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute

class MainAction(navController: NavHostController) {

    val navigateToMain: () -> Unit = {
        navController.navigate(MainRoute.Main.path) {
            popUpTo(MainRoute.Main.path) { inclusive = true }
        }
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
    val navigateToInclusive: (String) -> Unit = {
        navController.navigate(it) {
            popUpTo(it) { inclusive = true }
        }
    }
}
