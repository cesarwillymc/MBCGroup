package com.cesarwillymc.mbcgroup.presentation.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.mbcgroup.presentation.auth.state.AuthUiState
import com.cesarwillymc.mbcgroup.ui.validations.field.EmailField
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
class ForgotViewModel @Inject constructor() : ViewModel() {
    val emailText = EmailField()
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun forgotPassword() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
        }
    }
}
