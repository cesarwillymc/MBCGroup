package com.cesarwillymc.mbcgroup.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.mbcgroup.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.mbcgroup.presentation.auth.state.AuthUiState
import com.cesarwillymc.mbcgroup.util.state.isError
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun logout() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            logoutUseCase(Unit).let { result ->
                when {
                    result.isSuccess -> {
                        authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isError -> {
                        authUiState.update { AuthUiState(isError = true) }
                    }
                }
            }
        }
    }
}
