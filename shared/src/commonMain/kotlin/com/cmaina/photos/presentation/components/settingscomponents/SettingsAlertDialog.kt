package com.cmaina.photos.presentation.components.settingscomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cmaina.photos.presentation.components.photostext.FotosText
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel

@Composable
fun SettingItemDialog(
    openDialog: Boolean,
    isAppInDarkMode: Boolean,
    settingsViewModel: SettingsViewModel,
    onLightClicked: () -> Unit,
    onDarkClicked: () -> Unit,
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = {
                settingsViewModel.changeDialogOpenState()
            },
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.width(14.dp))
                        FotosText(text = "Choose theme", textColor = MaterialTheme.colors.onPrimary)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
//                                mainViewModel.changeAppTheme(dataStore, false)
                                onLightClicked()
                            }
                    ) {
                        RadioButton(
                            selected = isAppInDarkMode.not(),
                            onClick = {},
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.onPrimary)
                        )
                        FotosText(text = "Light")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
//                                mainViewModel.changeAppTheme(dataStore, true)
                                onDarkClicked()
                            }
                    ) {
                        RadioButton(
                            selected = isAppInDarkMode,
                            onClick = {},
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.onPrimary)
                        )
                        FotosText(text = "Dark")
                    }
                }
            }
        }
    }
}
