package com.app.flickr

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object FontSizeManager {
    var fontSize = mutableStateOf(16.sp)

    fun setFontSize(newSize: TextUnit) {
        fontSize.value = newSize
    }
}
