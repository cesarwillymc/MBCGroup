package com.cesarwillymc.mbcgroup.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.mbcgroup.R

@Composable
fun CustomSimpleScaffold(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    enableNavigationIcon: Boolean = true,
    @DrawableRes backIcon: Int = R.drawable.ic_arrow_back,
    navigateUp: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = title,
                navigationIcon = {
                    if (enableNavigationIcon) {
                        IconButton(
                            onClick = navigateUp,
                            modifier = modifier
                                .padding(start = dimensionResource(id = R.dimen.Small150))
                                .clip(CircleShape)
                                .size(dimensionResource(id = R.dimen.Large100))
                        ) {
                            Icon(
                                painter = painterResource(id = backIcon),
                                contentDescription = stringResource(R.string.desc_back)
                            )
                        }
                    }
                },
                actions = actions
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(paddingValues = padding)) {
                content()
            }
        }
    )
}
