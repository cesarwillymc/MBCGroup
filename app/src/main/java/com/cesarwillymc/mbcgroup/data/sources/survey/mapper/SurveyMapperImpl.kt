package com.cesarwillymc.mbcgroup.data.sources.survey.mapper

import com.cesarwillymc.GetSurveysQuery
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyList
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyMapperImpl @Inject constructor() : SurveyMapper {
    override fun dataSurveyToDomain(data: GetSurveysQuery.Data?): SurveyList {
        return data?.surveys?.let {
            SurveyList(
                hasNext = it.pageInfo.hasNextPage,
                list = it.edges.map { item ->
                    SurveyItem(
                        id = item.node.id,
                        title = item.node.title,
                        description = item.node.description,
                        coverImageUrl = item.node.coverImageUrl
                    )
                }
            )
        } ?: SurveyList(hasNext = false, listOf())
    }
}
