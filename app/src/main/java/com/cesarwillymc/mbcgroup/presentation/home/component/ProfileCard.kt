package com.cesarwillymc.mbcgroup.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.cesarwillymc.mbcgroup.R

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ProfileCard(
    picture: String,
    name: String,
    email: String
) {
    Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.Normal100))) {
        Box(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.ImageMedium))
                .clip(shape = CircleShape)
        ) {
            Image(
                painter = rememberImagePainter(picture),
                contentDescription = stringResource(R.string.lbl_profile),
                modifier = Modifier.size(dimensionResource(id = R.dimen.ImageMedium)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.Small100)))
        Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.Small50))) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Text(
                text = email,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun ProfileCardPreview() {
    ProfileCard(
        picture = "https://reqres.in/img/faces/8-image.jpg",
        name = "Jane Doe",
        email = "jane.doe@gmail.com"
    )
}
