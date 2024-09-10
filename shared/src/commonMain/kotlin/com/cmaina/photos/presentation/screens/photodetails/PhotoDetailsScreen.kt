package com.cmaina.photos.presentation.screens.photodetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.cmaina.photos.presentation.components.RelatedPhotosWrapper
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.navigate_back

@Composable
fun PhotoDetailsScreen(
    onBackBtnClicked: () -> Unit,
    photoId: String,
    onUserSectionClickedEvent: (String) -> Unit,
    onImageLikedEvent: () -> Unit,
    onPageSwappedEvent: (String) -> Unit,
    photoDetailsViewModel: PhotoDetailsViewModel = koinViewModel()
) {
    val uiState = photoDetailsViewModel.uiState.collectAsState().value

    LaunchedEffect(Unit) {
        photoDetailsViewModel.fetchPhoto(photoId)
    }

    when (uiState) {
        is PhotoDetailsUiState.Loading -> {}

        is PhotoDetailsUiState.Error -> {
        }

        is PhotoDetailsUiState.Success -> {
            with(uiState.details) {
                var page by remember { mutableStateOf(0) }

                Surface {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(
                            onClick = onBackBtnClicked
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(Res.string.navigate_back)
                            )
                        }

                        RelatedPhotosWrapper(
                            images = relatedImages,
                            pageInIteration = { page = it },
                            onPageSwapped = { onPageSwappedEvent(it) }
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        // region: Indicators
                        Row(
                            Modifier
                                .height(50.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            repeat(relatedImages.size) { iteration ->
                                val color = if (iteration == page) Color.Gray else Color.Black
                                Box(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .clip(CircleShape)
                                        .background(color)
                                        .size(15.dp)

                                )
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(0.95f),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            LikeAndDownloadSection(
                                userName = userName,
                                userPhotoUrl = userPhotoImageUrl,
                                numberOfLikes = numberOfLikes,
                                userHasLikedPhoto = photoIsLikedByUser,
                                onLikeClick = {

                                    onImageLikedEvent()
                                },
                                onDownloadClick = {},
                                onUserSectionClicked = { onUserSectionClickedEvent(userName) }
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun LikeAndDownloadSection(
    userName: String,
    userPhotoUrl: String,
    numberOfLikes: Int,
    userHasLikedPhoto: Boolean,
    onLikeClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onUserSectionClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row {
            AsyncImage(
                modifier = Modifier.clip(CircleShape).size(50.dp),
                model = userPhotoUrl,
                contentDescription = "",
            )
            Spacer(modifier = Modifier.size(10.dp))
            Column() {
                Text(text = userName, style = MaterialTheme.typography.titleLarge)
                Text(text = "$numberOfLikes likes", style = MaterialTheme.typography.bodyMedium)
            }
        }

    }

}
