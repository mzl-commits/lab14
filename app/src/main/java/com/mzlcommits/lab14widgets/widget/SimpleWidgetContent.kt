package com.mzlcommits.lab14widgets.widget

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.mzlcommits.lab14widgets.MainActivity

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
        Spacer(GlanceModifier.height(8.dp))
        Row {
            WidgetButton("Inicio", "home")
            WidgetButton("Entradas", "entries")
        }
        Row {
            WidgetButton("Salidas", "exits")
            WidgetButton("Historial", "history")
        }
    }
}

@Composable
private fun WidgetButton(label: String, destination: String) {
    val context = LocalContext.current
    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra(MainActivity.EXTRA_DESTINATION, destination)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
            Intent.FLAG_ACTIVITY_SINGLE_TOP
    }
    Button(
        text = label,
        onClick = actionStartActivity(intent),
        modifier = GlanceModifier.padding(2.dp)
    )
}
