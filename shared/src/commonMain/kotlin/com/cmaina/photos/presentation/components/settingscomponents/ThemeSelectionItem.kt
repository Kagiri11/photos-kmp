package com.cmaina.photos.presentation.components.settingscomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cmaina.photos.domain.models.settings.AppTheme
import com.cmaina.photos.presentation.components.photostext.FotosText
import org.jetbrains.compose.resources.stringResource

@Composable
fun ThemeSelectionItem(
    theme: AppTheme,
    isSelected: Boolean,
    onOptionSelected: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onOptionSelected()
            }
    ) {
        RadioButton(
            selected = isSelected,
            onClick = { onOptionSelected() },
            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.onPrimary)
        )
        FotosText(text = stringResource(theme.themeResource))
    }
}