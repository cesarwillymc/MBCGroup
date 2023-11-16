package com.cesarwillymc.mbcgroup.data.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.cesarwillymc.mbcgroup.BuildConfig
import com.cesarwillymc.mbcgroup.data.settings.network.AuthInterceptor
import com.cesarwillymc.mbcgroup.data.settings.network.SessionInterceptor
import com.cesarwillymc.mbcgroup.data.settings.network.VerifyTokenInterceptor
import com.cesarwillymc.mbcgroup.data.settings.network.util.AnonymousClient
import com.cesarwillymc.mbcgroup.data.settings.network.util.UserClient
import com.cesarwillymc.mbcgroup.data.sources.auth.service.AuthService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun gson() = Gson()

    @Singleton
    @Provides
    @AnonymousClient
    fun providesOkhttpAnonymous(authInterceptor: AuthInterceptor) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    @Singleton
    @Provides
    @UserClient
    fun providesOkhttpUser(
        sessionInterceptor: SessionInterceptor,
        verifyTokenInterceptor: VerifyTokenInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(sessionInterceptor)
        .authenticator(verifyTokenInterceptor)
        .build()

    @Singleton
    @Provides
    fun providesAuthService(
        @AnonymousClient okHttpClient: OkHttpClient
    ) = provideService<AuthService>(okHttpClient)

    @Singleton
    @Provides
    fun providesApolloService(
        @UserClient okHttpClient: OkHttpClient
    ): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BuildConfig.BASE_URL_GQL)
            .okHttpClient(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private inline fun <reified T : Any> provideService(
        okhttpClient: OkHttpClient
    ): T {
        return providesRetrofit(okhttpClient).create(T::class.java)
    }
}
