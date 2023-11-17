package com.cesarwillymc.mbcgroup.data.settings.network.util.error

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
sealed class ErrorSource : Exception() {

    object Network : ErrorSource()

    object Unknown : ErrorSource()

    data class ServiceError(
        val errorCode: String,
        val errorMessage: String?
    ) : ErrorSource()
}
