package com.cesarwillymc.mbcgroup.domain.usecase.survey.entities

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class SurveyList(
    val hasNext: Boolean,
    val list: List<SurveyItem>
)
