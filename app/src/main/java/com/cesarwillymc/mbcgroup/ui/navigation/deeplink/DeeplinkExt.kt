package com.cesarwillymc.mbcgroup.ui.navigation.deeplink

import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import com.cesarwillymc.mbcgroup.util.constants.FORMAT_DEEPLINK

private const val DOMAIN_APP = "culqui://cw.mc/"
private const val DOMAIN_HTTPS = "https://cw.mc/"

fun String.getFormatDeeplink(): String {
    return FORMAT_DEEPLINK.format(DOMAIN_APP, this)
}

fun String.generateDeepLinks(): List<NavDeepLink> {
    return listOf(
        navDeepLink {
            uriPattern = FORMAT_DEEPLINK.format(DOMAIN_HTTPS, this@generateDeepLinks)
        },
        navDeepLink {
            uriPattern = FORMAT_DEEPLINK.format(DOMAIN_APP, this@generateDeepLinks)
        }
    )
}
