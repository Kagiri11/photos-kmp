package com.cmaina.photos.presentation.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cmaina.photos.presentation.components.photostext.FotosTitleText
import com.cmaina.photos.presentation.components.userscreencomponents.UserButton



@Composable
fun NotAuthenticatedDialog(
    openDialog: Boolean,
    onDismissed: () -> Unit,
    onUserAcceptedAction: () -> Unit
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = { onDismissed() },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth(0.8f)
                    .semantics { contentDescription = "Setting dialog" }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    /*Icon(
                        painter = painterResource(""),
                        tint = MaterialTheme.colors.onPrimary,
                        contentDescription = "alert icon"
                    )*/
                    FotosTitleText(
                        text = "Please sign in to continue",
                        textColor = MaterialTheme.colors.onPrimary
                    )
                    UserButton(
                        text = "Sign In",
                        buttonColor = MaterialTheme.colors.onPrimary,
                        textColor = MaterialTheme.colors.primary,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ){
                        onUserAcceptedAction()
                    }
                    Button(
                        onClick = { onUserAcceptedAction() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onPrimary),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        FotosTitleText(text = "Sign In", textColor = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}
