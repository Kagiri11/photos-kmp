package com.cmaina.photos.presentation.screens

import androidx.compose.runtime.Composable
import com.cmaina.photos.presentation.navigation.PhotosApp
import com.cmaina.photos.presentation.ui.theme.PhotosTheme

@Composable
fun MainScreen() {
    PhotosTheme {
        PhotosApp()
    }
}