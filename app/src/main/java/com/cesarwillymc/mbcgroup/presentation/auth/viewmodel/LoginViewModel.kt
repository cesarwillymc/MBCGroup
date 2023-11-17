package com.cesarwillymc.mbcgroup.presentation.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.mbcgroup.data.settings.network.util.error.ErrorSource
import com.cesarwillymc.mbcgroup.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.mbcgroup.domain.usecase.auth.entities.AuthParams
import com.cesarwillymc.mbcgroup.presentation.auth.state.AuthUiState
import com.cesarwillymc.mbcgroup.ui.validations.field.EmailField
import com.cesarwillymc.mbcgroup.ui.validations.field.PasswordField
import com.cesarwillymc.mbcgroup.util.state.getError
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
class LoginViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    val emailText = EmailField()
    val passwordText = PasswordField()

    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun login() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            signInUseCase(
                AuthParams(
                    email = emailText.text.value,
                    password = passwordText.text.value
                )
            ).let { result ->
                when {
                    result.isSuccess -> {
                        authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isError -> {
                        var messageError: String? = result.getError().message
                        if (result.getError() is ErrorSource.ServiceError) {
                            messageError = (result.getError() as ErrorSource.ServiceError).errorMessage
                        }
                        authUiState.update {
                            AuthUiState(
                                isError = true,
                                errorMessage = messageError
                            )
                        }
                    }
                }
            }
        }
    }
}
