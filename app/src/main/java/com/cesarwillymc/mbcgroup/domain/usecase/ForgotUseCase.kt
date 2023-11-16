package com.cesarwillymc.mbcgroup.domain.usecase

import com.cesarwillymc.mbcgroup.data.sources.auth.AuthDataSource
import com.cesarwillymc.mbcgroup.di.IoDispatcher
import com.cesarwillymc.mbcgroup.domain.base.SuspendUseCase
import com.cesarwillymc.mbcgroup.util.state.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class ForgotUseCase @Inject constructor(
    private val repository: AuthDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<String, Unit>(
    dispatcher
) {
    override suspend fun execute(parameters: String): Result<Unit> {
        return repository.forgotPassword(parameters)
    }
}
