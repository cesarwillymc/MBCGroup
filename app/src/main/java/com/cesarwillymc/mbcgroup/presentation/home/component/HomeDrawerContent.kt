package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.ui.theme.TextColor
import com.cesarwillymc.mbcgroup.ui.theme.TextColorOpacity
import com.cesarwillymc.mbcgroup.ui.theme.Typography
import com.cesarwillymc.mbcgroup.util.constants.FRACTION_50
import com.cesarwillymc.mbcgroup.util.extension.rememberResponsive

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun HomeDrawerContent(
    onLogoutClick: () -> Unit
) {
    val responsive = rememberResponsive()
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100)),
        modifier = Modifier.padding(
            dimensionResource(id = R.dimen.Normal100)
        )
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                stringResource(id = R.string.desc_description),
                style = Typography.titleLarge,
                color = TextColor

            )
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Large175)))
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(R.string.lbl_profile),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.Large125)),
                    contentScale = ContentScale.Crop
                )
            }
        }
        HorizontalDivider(modifier = Modifier.width(responsive.withR(FRACTION_50)))
        Text(
            stringResource(id = R.string.lbl_logout),
            style = Typography.bodyMedium,
            color = TextColorOpacity,
            modifier = Modifier.clickable { onLogoutClick() }
        )
    }
}
