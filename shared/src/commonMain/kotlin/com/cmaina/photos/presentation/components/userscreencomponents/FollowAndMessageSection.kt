package com.cmaina.photos.presentation.components.userscreencomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cmaina.photos.presentation.components.photostext.FotosText
import com.cmaina.photos.presentation.components.photostext.FotosTitleText

@Composable
fun FollowAndMessageButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        UserButton(
            text = "Follow",
            buttonColor = Color.Black,
            textColor = Color.White,
            modifier = Modifier.weight(1f)
        ) {}
    }
}

@Composable
fun FollowingSection(modifier: Modifier, photos: Int, followers: Int, following: Int) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DetailsColumn(text = "Photos", number = photos)
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
        )
        DetailsColumn(text = "Followers", number = followers)
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
        )
        DetailsColumn(text = "Following", number = following)
    }
}

@Composable
fun DetailsColumn(text: String, number: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(100.dp)) {
        FotosText(text = text)
        FotosTitleText(text = number.toString(), textColor = MaterialTheme.colors.primary)
    }
}

@Composable
fun UserButton(
    text: String,
    buttonColor: Color,
    textColor: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(50),
        modifier = modifier
            .height(55.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        FotosText(text = text, textColor = textColor)
    }
}
