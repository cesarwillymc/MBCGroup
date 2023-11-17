package com.cesarwillymc.mbcgroup.presentation.auth.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.ui.components.CustomPrimaryButton
import com.cesarwillymc.mbcgroup.ui.components.CustomTextField
import com.cesarwillymc.mbcgroup.ui.theme.TextColorOpacity
import com.cesarwillymc.mbcgroup.ui.validations.field.EmailField
import com.cesarwillymc.mbcgroup.ui.validations.field.PasswordField

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.SignInContent(
    passwordField: PasswordField,
    emailText: EmailField,
    onContinue: () -> Unit,
    onClickForgotPassword: () -> Unit

) {
    val isErrorPassword by passwordField.isError.collectAsState()
    val isErrorEmail by emailText.isError.collectAsState()

    CustomTextField(
        query = emailText.text.collectAsState().value,
        onQueryChange = emailText::setText,
        hintText = stringResource(R.string.lbl_email),
        isError = isErrorEmail
    )
    CustomTextField(
        query = passwordField.text.collectAsState().value,
        onQueryChange = passwordField::setText,
        hintText = stringResource(R.string.lbl_password),
        isTypePassword = true,
        isError = isErrorPassword,
        trailingComposable = {
            Text(
                text = stringResource(R.string.lbl_forgot),
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.Small150))
                    .clickable {
                        onClickForgotPassword()
                    },
                color = TextColorOpacity
            )
        }
    )
    CustomPrimaryButton(
        title = stringResource(R.string.til_sign_in),
        onClick = onContinue,
        isEnabled = !(isErrorPassword || isErrorEmail)
    )
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun SignInContentPreview() {
    AuthScaffold(
        isIconsTopEnabled = true,
        content = {
            SignInContent(PasswordField(), EmailField(), {}, {})
        }
    )
}
