package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.cesarwillymc.mbcgroup.R
import com.cesarwillymc.mbcgroup.ui.theme.TextColor
import com.cesarwillymc.mbcgroup.ui.theme.Typography
import com.cesarwillymc.mbcgroup.util.extension.formatDateWithSimpleDateFormat
import com.valentinilk.shimmer.shimmer
import java.util.Date

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ProfileCard(
    isShimmer: Boolean
) {

    val modifier = if (isShimmer) {
        Modifier.shimmer()
    } else {
        Modifier
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = dimensionResource(id = R.dimen.Normal100)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Normal100))) {
            Text(
                text = formatDateWithSimpleDateFormat(Date()).uppercase(),
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.ExtraBold),
                color = TextColor,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.lbl_today).uppercase(),
                style = Typography.titleLarge,
                color = TextColor,
                modifier = modifier
            )
        }
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Small100)))

        Box(
            modifier = modifier
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
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun ProfileCardPreview() {
    ProfileCard(
        isShimmer = true
    )
}
