package com.cesarwillymc.mbcgroup.domain.usecase.auth

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
class LogoutUseCase @Inject constructor(
    private val repository: AuthDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Unit>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<Unit> {
        return repository.logout()
    }
}
