package com.cesarwillymc.mbcgroup.ui.validations.entities

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
data class FieldValidator(
    val isSuccessValidator: (String) -> Boolean = { true }
)
