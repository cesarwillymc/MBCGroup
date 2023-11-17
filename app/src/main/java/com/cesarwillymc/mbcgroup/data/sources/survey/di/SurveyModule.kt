package com.cesarwillymc.mbcgroup.data.sources.survey.di

import com.cesarwillymc.mbcgroup.data.sources.survey.SurveyDataSource
import com.cesarwillymc.mbcgroup.data.sources.survey.SurveyRepository
import com.cesarwillymc.mbcgroup.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.mbcgroup.data.sources.survey.mapper.SurveyMapperImpl
import com.cesarwillymc.mbcgroup.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.mbcgroup.data.sources.survey.remote.SurveyRemoteDataSourceImpl
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
abstract class SurveyModule {

    @Singleton
    @Binds
    abstract fun bindsSurveyDataSource(surveyRepository: SurveyRepository): SurveyDataSource

    @Singleton
    @Binds
    abstract fun bindsSurveyResultMapper(
        surveyMapperImpl: SurveyMapperImpl
    ): SurveyMapper

    @Singleton
    @Binds
    abstract fun bindsSurveyRemoteDataSource(
        surveyRemoteDataSourceImpl: SurveyRemoteDataSourceImpl
    ): SurveyRemoteDataSource
}
