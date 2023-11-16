package com.cesarwillymc.mbcgroup.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.mbcgroup.domain.usecase.GetLoggedStateUseCase
import com.cesarwillymc.mbcgroup.ui.navigation.route.AuthRoute
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute
import com.cesarwillymc.mbcgroup.util.extension.orEmpty
import com.cesarwillymc.mbcgroup.util.state.dataOrNull
import com.cesarwillymc.mbcgroup.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class SplashViewModel @Inject constructor(private val isLogged: GetLoggedStateUseCase) :
    ViewModel() {
    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination get() = _startDestination

    init {
        loadMainRoute()
    }

    fun loadMainRoute() {
        viewModelScope.launch {
            isLogged(Unit).let { result ->
                if (result.isSuccess && result.dataOrNull().orEmpty()) {
                    _startDestination.update { MainRoute.Main.path }
                } else {
                    _startDestination.update { AuthRoute.Auth.path }
                }
            }
        }
    }
}
