package com.cmaina.photos.presentation.components.settingscomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.cmaina.photos.presentation.utils.Language
import com.cmaina.photos.presentation.utils.LanguageList
import org.jetbrains.compose.resources.stringResource
import photos.shared.generated.resources.Res
import photos.shared.generated.resources.choose_language

@Composable
fun LanguageSelectionDialog(
    currentLanguage: Language,
    onDialogDismissed: () -> Unit,
    onLanguageSelected: (Language) -> Unit
) {
    Dialog(
        onDismissRequest = onDialogDismissed
    ) {
        Card(
            modifier = Modifier.fillMaxHeight(0.3f).fillMaxWidth(0.8f)
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
                        text = stringResource(Res.string.choose_language),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                LanguageList.forEach { language ->
                    LanguageSelectionItem(
                        isSelectedLanguage = currentLanguage == language,
                        language = language,
                        onLanguageSelected = onLanguageSelected
                    )
                }
            }

        }
    }
}