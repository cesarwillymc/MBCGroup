package com.cesarwillymc.mbcgroup.data.settings.network.util.error

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorSource
}
