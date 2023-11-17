package com.cesarwillymc.mbcgroup.ui.validations

import androidx.compose.runtime.mutableStateListOf
import com.cesarwillymc.mbcgroup.ui.validations.entities.FieldValidator
import com.cesarwillymc.mbcgroup.util.constants.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
You can  use:
 **  validations -> when  you are typing and its necessary show some helper
 **/
open class TextFieldState(
    private val validations: List<FieldValidator> = emptyList()
) {

    private val requirementsComplete = mutableStateListOf<FieldValidator>()
    private val requirementsIncomplete = mutableStateListOf<FieldValidator>()

    /**
     * State text
     */
    private val _text = MutableStateFlow(EMPTY_STRING)
    val text get() = _text.asStateFlow()

    /**
     * State error
     */
    private val _isError = MutableStateFlow(true)
    val isError get() = _isError.asStateFlow()

    /**
     * Change the text when passed the validationsRequire
     */
    fun setText(value: String) {
        _text.value = value
        validate()
    }

    /**
     * Reset TextField without validations for empty text
     */
    fun onResetTextField() {
        _text.value = EMPTY_STRING
        _isError.value = false
    }

    /**
     * Do the validations
     */
    private fun validate() {
        var isSuccess = true
        requirementsIncomplete.clear()
        requirementsComplete.clear()

        validations.forEach {
            if (!it.isSuccessValidator(text.value)) {
                isSuccess = false
                requirementsIncomplete.add(it)
            } else {
                requirementsComplete.add(it)
            }
        }

        _isError.value = !isSuccess
    }

    /**
     * Verify only all validations, no the requires
     */
    fun isValid() = validations.all { it.isSuccessValidator(text.value) }
}
