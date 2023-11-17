package com.cesarwillymc.mbcgroup.presentation.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_20
import com.cesarwillymc.mbcgroup.util.extension.rememberResponsive

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun AuthScaffold(
    isIconsTopEnabled: Boolean = false,
    onNavigateUp: () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    val responsive = rememberResponsive()
    Scaffold { paddingValues ->
        Image(
            painter = painterResource(id = R.drawable.img_overlay),
            contentDescription = stringResource(R.string.lbl_onbackground),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(dimensionResource(id = R.dimen.Normal100))
                .fillMaxSize()
        ) {
            if (isIconsTopEnabled) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(id = R.string.desc_back),
                    modifier = Modifier
                        .clickable(onClick = onNavigateUp)
                        .align(Alignment.TopStart),
                    tint = Color.White
                )
                Box(modifier = Modifier.align(Alignment.TopEnd)) {
                    trailingIcon()
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100))) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "Icon logo",
                        modifier = Modifier.align(Alignment.Center).padding(
                            top = responsive.heightR(
                                FRACTION_20
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Large100)))
                content()
            }
        }
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun AuthScaffoldPreview() {
    AuthScaffold(
        isIconsTopEnabled = true,
        content = {
        }
    )
}
