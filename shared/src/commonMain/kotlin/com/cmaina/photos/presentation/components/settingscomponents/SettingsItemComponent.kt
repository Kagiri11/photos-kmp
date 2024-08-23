package com.cmaina.photos.presentation.components.settingscomponents

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Setting(
    settingAttribute: String,
    attributeValue: String,
    settingIcon: ImageVector,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 10.dp)
            .semantics {
                contentDescription = "setting column"
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onClick() }.fillMaxWidth()
        ) {
            Icon(
                imageVector = settingIcon,
                contentDescription = "theme icon"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = settingAttribute,
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 16.sp,
                    )
                )
                Text(
                    text = attributeValue,
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 11.sp
                    )
                )
            }
        }
    }
}
