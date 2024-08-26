package com.cmaina.photos.presentation.components.settingscomponents

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
import com.cmaina.photos.domain.models.settings.AppThemes
import com.cmaina.photos.presentation.screens.settings.SettingsViewModel
import org.jetbrains.compose.resources.stringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.choose_theme

@Composable
fun ThemeDialog(
    appTheme: AppTheme,
    settingsViewModel: SettingsViewModel,
    onOptionSelected: (AppTheme) -> Unit
) {
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
                        text = stringResource(Res.string.choose_theme), style = TextStyle(
                            color = MaterialTheme.colors.onPrimary,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                AppThemes.forEach { theme ->
                    ThemeSelectionItem(
                        theme = theme,
                        isSelected = theme == appTheme,
                        onOptionSelected = { onOptionSelected(theme) }
                    )
                }
            }
        }
    }
}
