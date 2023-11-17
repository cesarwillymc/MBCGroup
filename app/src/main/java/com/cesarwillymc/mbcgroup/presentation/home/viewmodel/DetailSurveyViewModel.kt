package com.cesarwillymc.mbcgroup.presentation.home.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cesarwillymc.mbcgroup.presentation.home.state.DetailSurveyUiState
import com.cesarwillymc.mbcgroup.ui.navigation.route.MainRoute
import com.cesarwillymc.mbcgroup.util.extension.fromJson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class DetailSurveyViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val detailUiState get() = _detailUiState
    private val _detailUiState = MutableStateFlow(DetailSurveyUiState())

    init {
        onLoadArgument()
    }

    private fun onLoadArgument() {
        savedStateHandle.get<String>(MainRoute.ARGUMENT)?.let {
            _detailUiState.update { update -> update.copy(data = fromJson(it)) }
        }
    }
}
