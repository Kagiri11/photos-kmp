package com.cmaina.photos.presentation.components.photostext

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun FotosText(modifier: Modifier = Modifier, text: String, textColor: Color = MaterialTheme.colors.onPrimary, fontSize: Int = 16) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1.copy(color = textColor, fontSize = fontSize.sp),
        modifier = modifier
    )
}

@Composable
fun FotosTitleText(text: String, textColor: Color, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1.copy(color = textColor)
    )
}

@Composable
fun FotosButtonText(text: String, textColor: Color, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.button.copy(color = textColor),
        modifier = modifier
    )
}
