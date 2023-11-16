package com.cesarwillymc.mbcgroup.data.sources.survey.remote

import com.cesarwillymc.GetSurveysQuery
import com.cesarwillymc.mbcgroup.util.state.Result

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface SurveyRemoteDataSource {
    suspend fun getSurveys():  Result<GetSurveysQuery.Data?>
}