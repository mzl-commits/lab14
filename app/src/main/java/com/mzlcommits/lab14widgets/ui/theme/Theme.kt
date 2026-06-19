package com.mzlcommits.lab14widgets.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val IndustrialColors = darkColorScheme(
    primary = Primary,
    background = Background,
    surface = Surface,
    onBackground = OnSurface,
    onSurface = OnSurface
)

@Composable
fun Lab14WidgetsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = IndustrialColors,
        content = content
    )
}

