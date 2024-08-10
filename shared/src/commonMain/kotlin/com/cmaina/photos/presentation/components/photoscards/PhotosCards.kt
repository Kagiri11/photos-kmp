package com.cmaina.photos.presentation.components.photoscards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun PhotoCardItem(
    imageUrl: String,
    contentDescription: String,
    onPhotoClicked: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(2),
        modifier = Modifier
            .height(230.dp)
            .fillMaxWidth()
            .padding(1.dp)
            .clickable(
                onClick = onPhotoClicked
            ),
    ) {
        AsyncImage(
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            model = imageUrl
        )
    }
}
