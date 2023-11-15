package com.cesarwillymc.mbcgroup.data.settings.network

import android.os.Build
import com.cesarwillymc.mbcgroup.BuildConfig
import com.cesarwillymc.mbcgroup.data.sources.preferences.PreferencesDao
import com.cesarwillymc.mbcgroup.util.extension.orEmpty
import com.cesarwillymc.mbcgroup.util.state.dataOrNull
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

// Here the token could be used
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Append query parameters to the original request
        val modifiedUrl = originalRequest.url.newBuilder()
            .addQueryParameter(CLIENT_ID, BuildConfig.CLIENT_ID)
            .addQueryParameter(CLIENT_SECRET, BuildConfig.CLIENT_SECRET)
            .build()

        // Create a new request with the modified URL
        val modifiedRequest = originalRequest.newBuilder()
            .url(modifiedUrl)
            .build()
        return chain.proceed(modifiedRequest)
    }

    companion object {
        private const val CLIENT_ID = "client_id"
        private const val CLIENT_SECRET = "client_secret"
    }
}
