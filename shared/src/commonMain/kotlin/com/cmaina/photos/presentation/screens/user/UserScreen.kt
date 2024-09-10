package com.cmaina.photos.presentation.screens.user

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.cmaina.photos.presentation.components.userscreencomponents.UserPhotos
import com.cmaina.photos.presentation.components.photostext.FotosTitleText
import com.cmaina.photos.presentation.components.userscreencomponents.FollowAndMessageButtons
import com.cmaina.photos.presentation.components.userscreencomponents.FollowingSection
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreen(
    onBackPressed: () -> Unit,
    onUserPhotoClicked: (String) -> Unit,
    userViewModel: UserViewModel = koinViewModel()
) {
    val uiState = userViewModel.uiState.collectAsState().value

    when (uiState) {
        is UserUiState.Loading -> {}
        is UserUiState.Error -> {}
        is UserUiState.Success -> {
            Column(modifier = Modifier.fillMaxSize()) {
                UserDetailsScreen(
                    onBackPressed = onBackPressed,
                    userUiDetails = uiState.uiDetails,
                    onUserPhotoClicked = onUserPhotoClicked
                )
            }
        }
    }

}

@Composable
fun UserDetailsScreen(
    onBackPressed: () -> Unit,
    userUiDetails: UserUiDetails,
    onUserPhotoClicked: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.15f)
                .background(color = MaterialTheme.colorScheme.primary),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(onClick = onBackPressed)
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More"
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }

        Column {
            Card(
                modifier = Modifier
                    .size(80.dp),
                shape = CircleShape
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentDescription = "",
                    model = userUiDetails.userImageUrl
                )

            }

            FotosTitleText(
                text = userUiDetails.userName,
                textColor = Color.Black,
                modifier = Modifier
            )

            FollowingSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                photos = userUiDetails.numberOfPhotosByUser,
                followers = userUiDetails.followersCount,
                following = userUiDetails.followingCount
            )

            FollowAndMessageButtons(
                modifier = Modifier.wrapContentHeight()
            )

            val flowOfPhotos = userUiDetails.userPhotos.collectAsLazyPagingItems()
            UserPhotos(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(MaterialTheme.colorScheme.primary),
                photos = flowOfPhotos,
                onUserPhotoClicked = onUserPhotoClicked
            )

        }
    }
}

