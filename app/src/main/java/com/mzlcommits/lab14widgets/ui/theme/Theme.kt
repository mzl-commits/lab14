package com.mzlcommits.lab14widgets.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val IndustrialColors = darkColorScheme(
    primary = Turquoise,
    secondary = IndustrialOrange,
    tertiary = Lime,
    background = Background,
    surface = Surface,
    surfaceVariant = SurfaceRaised,
    onBackground = OnSurface,
    onSurface = OnSurface,
    onSurfaceVariant = TextSecondary,
    error = Error
)

@Composable
fun Lab14WidgetsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = IndustrialColors,
        content = content
    )
}
