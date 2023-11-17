package com.cesarwillymc.mbcgroup.data.di

import android.content.Context
import android.content.SharedPreferences
import com.cesarwillymc.mbcgroup.BuildConfig
import com.cesarwillymc.mbcgroup.data.settings.local.EncryptedSharedPreferencesFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
class DataModule {
    @Singleton
    @Provides
    fun getEncryptedSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
        return EncryptedSharedPreferencesFactory(
            BuildConfig.SHARED_PREFERENCES_NAME,
            appContext
        ).sharedPreferences
    }
}
