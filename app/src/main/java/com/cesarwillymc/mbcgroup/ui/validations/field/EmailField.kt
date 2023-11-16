package com.cesarwillymc.mbcgroup.ui.validations.field

import com.cesarwillymc.mbcgroup.ui.validations.TextFieldState
import com.cesarwillymc.mbcgroup.ui.validations.common.CommonRules

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class EmailField : TextFieldState(
    validations = listOf(CommonRules.notEmptyField, CommonRules.validEmail)
)
