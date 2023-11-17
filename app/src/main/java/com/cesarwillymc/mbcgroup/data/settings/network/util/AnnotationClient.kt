package com.cesarwillymc.mbcgroup.data.settings.network.util

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class AnonymousClient

// This could be used in screen that need auth
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class UserClient
