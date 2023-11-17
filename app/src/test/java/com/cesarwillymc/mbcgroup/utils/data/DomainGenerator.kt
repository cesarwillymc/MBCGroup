package com.cesarwillymc.mbcgroup.utils.data

import com.cesarwillymc.mbcgroup.domain.usecase.auth.entities.Auth
import com.cesarwillymc.mbcgroup.domain.usecase.auth.entities.AuthParams
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.mbcgroup.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
object DomainGenerator {
    val surveys = SurveyList(
        hasNext = true,
        listOf(
            SurveyItem(
                "d5de6a8f8f5f1cfe51bc",
                "Scarlett Bangko",
                "We'd love ot hear from you!",
                "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
            ),
            SurveyItem(
                "ed1d4f0ff19a56073a14",
                "ibis Bangkok Riverside",
                "We'd love ot hear from you!",
                "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
            ),
            SurveyItem(
                "270130035d415c1d90bb",
                "21 on Rajah",
                "We'd love ot hear from you!",
                "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_"
            )
        )
    )

    const val email = "cesarwilly.mc@gmail.com"
    const val password = "123456678"

    val authRequest = AuthParams(
        email = email,
        password = password
    )
    val authResponse = Auth(
        tokenType = "Bearer",
        token = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E",
        refreshToken = "ZyMyMcu5qhfnUkHdJlEzGnrdmVhlVygA2YXTX8lUf0E"
    )
}
