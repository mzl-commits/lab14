package com.mzlcommits.lab14widgets.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Composable
fun SimpleWidgetContent() {
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ColorProvider(Color(0xFF1B232D)))
            .padding(16.dp)
    ) {
        Text(
            text = "Panel Logístico",
            style = TextStyle(color = ColorProvider(Color.White))
        )
        Spacer(GlanceModifier.height(8.dp))
        Text(
            text = "Estado: Operativo",
            style = TextStyle(color = ColorProvider(Color(0xFF2DD4BF)))
        )
        Text(
            text = "Batería: 82 %",
            style = TextStyle(color = ColorProvider(Color.White))
        )
    }
}

