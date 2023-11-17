package com.cesarwillymc.mbcgroup.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.ui.theme.ButtonBackground
import com.cesarwillymc.mbcgroup.ui.theme.TextColorButton

@Composable
fun CustomPrimaryButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    title: String,
    textColor: Color = TextColorButton,
    isEnabled: Boolean = true,
    backGroundColor: Color = ButtonBackground,
    @DrawableRes leadingIcon: Int? = null,
    onClick: () -> Unit
) {
    val modifierText = if (leadingIcon == null) {
        Modifier
            .padding(dimensionResource(id = R.dimen.Small100))
    } else {
        Modifier
            .padding(dimensionResource(id = R.dimen.Small100))
            .fillMaxWidth()
    }
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = backGroundColor,
            contentColor = textColor,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation()
    ) {
        if (leadingIcon != null) {
            Image(
                painter = painterResource(id = leadingIcon),
                contentDescription = stringResource(R.string.lbl_icon, title),
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.ImageIcon))
            )
        }
        Text(
            text = title,
            modifier = modifierText,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun CustomPrimaryButtonPreview() {
    CustomPrimaryButton(
        title = "Submit",
        isEnabled = false,
        onClick = {},
        leadingIcon = R.drawable.ic_arrow_back
    )
}
