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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.presentation.components.photostext.FotosText
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel

@Composable
fun SettingItemDialog(
    openDialog: Boolean,
    appTheme: AppTheme,
    settingsViewModel: SettingsViewModel,
    onOptionSelected: (AppTheme) -> Unit
) {
    if (openDialog) {
        Dialog(
            onDismissRequest = { settingsViewModel.changeDialogOpenState() },
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
                        Text(
                            text = "Choose theme", style = TextStyle(
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onOptionSelected(AppTheme.Light)
                            }
                    ) {
                        RadioButton(
                            selected = appTheme == AppTheme.Light,
                            onClick = { onOptionSelected(AppTheme.Light) },
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
                                onOptionSelected(AppTheme.Dark)
                            }
                    ) {
                        RadioButton(
                            selected = appTheme == AppTheme.Dark,
                            onClick = { onOptionSelected(AppTheme.Dark) },
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.onPrimary)
                        )
                        FotosText(text = "Dark")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
//                                mainViewModel.changeAppTheme(dataStore, true)
                                onOptionSelected(AppTheme.SystemDefault)
                            }
                    ) {
                        RadioButton(
                            selected = appTheme == AppTheme.SystemDefault,
                            onClick = { onOptionSelected(AppTheme.SystemDefault) },
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.onPrimary)
                        )
                        FotosText(text = "System Default")
                    }
                }
            }
        }
    }
}
