package com.cesarwillymc.mbcgroup.ui.navigation.route

sealed class AuthRoute(path: String) : Route(path) {
    object Splash : AuthRoute(SPLASH)
    object SignIn : AuthRoute(SIGN_IN_PATH)
    object Forgot : AuthRoute(FORGOT_PATH)
    object Auth : AuthRoute(AUTH_ROUTE)
    companion object {
        const val EMAIL_KEY = "email"
        const val SIGN_IN_PATH = "login/{$EMAIL_KEY}"
        const val FORGOT_PATH = "forgot"
        const val SPLASH = "splash"
        const val AUTH_ROUTE = "auth"
    }
}
