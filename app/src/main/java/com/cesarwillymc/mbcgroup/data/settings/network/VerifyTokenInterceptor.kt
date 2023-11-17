package com.cesarwillymc.mbcgroup.data.settings.network

import com.cesarwillymc.mbcgroup.data.settings.network.SessionInterceptor.Companion.TOKEN_KEY
import com.cesarwillymc.mbcgroup.data.sources.auth.AuthDataSource
import com.cesarwillymc.mbcgroup.util.constants.EMPTY_STRING
import com.cesarwillymc.mbcgroup.util.extension.orEmpty
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.dataOrNull
import com.cesarwillymc.mbcgroup.util.state.getData
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class VerifyTokenInterceptor @Inject constructor(
    private val dataSource: AuthDataSource
) : Authenticator {
    private val userData: Result<Boolean>
        get() = runBlocking {
            dataSource.isLogged()
        }

    override fun authenticate(route: Route?, response: Response): Request? {
        var session: String = EMPTY_STRING
        if (userData.dataOrNull().orEmpty()) {
            runBlocking {
                dataSource.refreshToken().apply {
                    if (isSuccess) {
                        session = getData().tokenType + " " + getData().token
                    }
                }
            }
        }
        return response.request.newBuilder()
            .removeHeader(TOKEN_KEY)
            .header(TOKEN_KEY, session)
            .build()
    }
}
