package com.cesarwillymc.mbcgroup.ui.validations.common

import androidx.core.util.PatternsCompat
import com.cesarwillymc.mbcgroup.ui.validations.entities.FieldValidator

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
object CommonRules {
    private const val PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*[@#\$%^&+=.\\-_*!'<>,/:;?])" +
        "(?=" +
        ".*?[^\\s]).{8,}$"
    val notEmptyField = FieldValidator(
        isSuccessValidator = { it.isNotEmpty() }
    )
    val validEmail = FieldValidator(
        isSuccessValidator = { PatternsCompat.EMAIL_ADDRESS.toRegex().matches(it) }
    )
    val validPassword = FieldValidator(
        isSuccessValidator = {
            // PASSWORD_REGEX.toRegex().matches(it) }
            it.isNotEmpty()
        }

    )
}
