package com.app.flickr.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.app.flickr.FontSizeManager

@Composable
fun FontSizeDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Adjust Font Size") },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val fontSize by FontSizeManager.fontSize
                val sliderPosition =
                    (fontSize.value - 12) / 24 // Assuming font size range 12sp to 36sp

                Slider(
                    value = sliderPosition,
                    onValueChange = { newValue ->
                        val newSize = 12 + (newValue * 24)
                        FontSizeManager.setFontSize(newSize.sp)
                    },
                    valueRange = 0f..1f,
                    steps = 5
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}
