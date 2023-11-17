package com.cesarwillymc.mbcgroup.data.sources.auth.di

import com.cesarwillymc.mbcgroup.data.sources.auth.AuthDataSource
import com.cesarwillymc.mbcgroup.data.sources.auth.AuthRepository
import com.cesarwillymc.mbcgroup.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.mbcgroup.data.sources.auth.mapper.AuthResultMapperImpl
import com.cesarwillymc.mbcgroup.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.mbcgroup.data.sources.auth.remote.AuthRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Singleton
    @Binds
    abstract fun bindsAuthDataSource(authRepository: AuthRepository): AuthDataSource

    @Singleton
    @Binds
    abstract fun bindsAuthResultMapper(
        authResultMapper: AuthResultMapperImpl
    ): AuthResultMapper

    @Singleton
    @Binds
    abstract fun bindsAuthRemoteDataSource(
        authResultRemoteDataSource: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource
}
