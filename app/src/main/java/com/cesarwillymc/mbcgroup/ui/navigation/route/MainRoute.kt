package com.cesarwillymc.mbcgroup.ui.navigation.route

sealed class MainRoute(path: String) : Route(path) {
    object Main : MainRoute(MAIN_ROUTE)
    object Detail : MainRoute(DETAIL_ROUTE)
    companion object {
        const val ARGUMENT = "detailargs"
        const val MAIN_ROUTE = "home"
        const val DETAIL_ROUTE = "detail/{$ARGUMENT}"
    }
}
