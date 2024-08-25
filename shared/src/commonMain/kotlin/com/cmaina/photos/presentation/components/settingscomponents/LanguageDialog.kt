package com.cmaina.photos.presentation.components.settingscomponents

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun LanguageSelectionDialog(
    isDialogOpen: Boolean,
    onDialogDismissed: Boolean
) {
    Dialog(
        onDismissRequest = {}
    ) {
        Card(
            modifier = Modifier.fillMaxHeight(0.3f).fillMaxWidth(0.8f)
        ) {

        }
    }
}