package com.cesarwillymc.mbcgroup.data.sources.survey

import com.cesarwillymc.mbcgroup.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.mbcgroup.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.mbcgroup.util.state.Result
import com.cesarwillymc.mbcgroup.util.state.map
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRepository @Inject constructor(
    private val surveyRemoteDataSource: SurveyRemoteDataSource,
    private val mapper: SurveyMapper
):SurveyDataSource {
    override suspend fun getSurveys(): Result<SurveyList> {
        return surveyRemoteDataSource.getSurveys().map(mapper::dataSurveyToDomain)
    }
}