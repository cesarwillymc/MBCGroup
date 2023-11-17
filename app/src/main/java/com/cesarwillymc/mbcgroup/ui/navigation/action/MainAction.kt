package com.cesarwillymc.mbcgroup.ui.navigation.action

import androidx.navigation.NavHostController
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute.Companion.ARGUMENT
import com.cesarwillymc.mbcgroup.util.extension.toJson

class MainAction(navController: NavHostController) {

    val navigateToMain: () -> Unit = {
        navController.navigate(MainRoute.Main.path) {
            popUpTo(MainRoute.Main.path) { inclusive = true }
        }
    }
    val navigateToDetail: (SurveyItem) -> Unit = {
        navController.navigate(MainRoute.Detail.path.replace("{$ARGUMENT}", toJson(it)))
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
