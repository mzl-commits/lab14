package com.mzlcommits.lab14widgets.widget

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.ButtonDefaults
import androidx.glance.GlanceModifier
import androidx.glance.LocalContext
import androidx.glance.LocalSize
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.mzlcommits.lab14widgets.MainActivity

private val WidgetBackground = ColorProvider(Color(0xFF171E27))
private val WidgetPrimary = ColorProvider(Color(0xFF2DD4BF))
private val WidgetOrange = ColorProvider(Color(0xFFFF9F43))
private val WidgetWhite = ColorProvider(Color(0xFFF4F7F8))
private val WidgetMuted = ColorProvider(Color(0xFFB9C3CC))

@Composable
fun SimpleWidgetContent() {
    val size = LocalSize.current
    val isLarge = size.width >= 300.dp && size.height >= 240.dp
    val isMedium = !isLarge && size.width >= 240.dp && size.height >= 150.dp

    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(WidgetBackground)
            .padding(if (isLarge) 16.dp else 12.dp)
    ) {
        WidgetHeader(compact = !isLarge)
        Spacer(GlanceModifier.height(6.dp))
        when {
            isLarge -> LargeContent()
            isMedium -> MediumContent()
            else -> SmallContent()
        }
    }
}

@Composable
private fun WidgetHeader(compact: Boolean) {
    Text(
        text = "PANEL LOGÍSTICO",
        style = TextStyle(
            color = WidgetPrimary,
            fontSize = if (compact) 15.sp else 17.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
private fun SmallContent() {
    WidgetLine("Estado", "Operativo", WidgetPrimary)
    WidgetLine("Batería", "82 %", WidgetWhite)
    Spacer(GlanceModifier.height(4.dp))
    Row(GlanceModifier.fillMaxWidth()) {
        WidgetButton("Entradas", "entries", GlanceModifier.defaultWeight())
        WidgetButton("Salidas", "exits", GlanceModifier.defaultWeight())
    }
}

@Composable
private fun MediumContent() {
    Row(GlanceModifier.fillMaxWidth()) {
        Column(GlanceModifier.defaultWeight()) {
            WidgetLine("Estado", "Operativo", WidgetPrimary)
            WidgetLine("Carga", "Caja A-102", WidgetWhite)
            WidgetLine("Ubicación", "Zona de despacho", WidgetWhite)
        }
        Column(GlanceModifier.defaultWeight()) {
            WidgetLine("Entradas", "5", WidgetOrange)
            WidgetLine("Salidas", "4", WidgetOrange)
            WidgetLine("Batería", "82 %", WidgetPrimary)
        }
    }
    Spacer(GlanceModifier.height(4.dp))
    MainButtons()
}

@Composable
private fun LargeContent() {
    Row(GlanceModifier.fillMaxWidth()) {
        Column(GlanceModifier.defaultWeight()) {
            WidgetLine("Estado", "Operativo", WidgetPrimary)
            WidgetLine("Carga", "Caja A-102", WidgetWhite)
            WidgetLine("Peso", "18 kg", WidgetWhite)
            WidgetLine("Ubicación", "Zona de despacho", WidgetWhite)
            WidgetLine("Batería", "82 %", WidgetPrimary)
        }
        Column(GlanceModifier.defaultWeight()) {
            WidgetLine("Entradas", "5", WidgetOrange)
            WidgetLine("Salidas", "4", WidgetOrange)
            WidgetLine("Último movimiento", "Entrega completada", WidgetWhite)
            WidgetLine("Próximo destino", "Almacén B", WidgetWhite)
            WidgetLine("Sistema", "Sin alertas", WidgetPrimary)
        }
    }
    Spacer(GlanceModifier.height(6.dp))
    MainButtons()
}

@Composable
private fun MainButtons() {
    Row(GlanceModifier.fillMaxWidth()) {
        WidgetButton("Inicio", "home", GlanceModifier.defaultWeight())
        WidgetButton("Entradas", "entries", GlanceModifier.defaultWeight())
    }
    Row(GlanceModifier.fillMaxWidth()) {
        WidgetButton("Salidas", "exits", GlanceModifier.defaultWeight())
        WidgetButton("Historial", "history", GlanceModifier.defaultWeight())
    }
}

@Composable
private fun WidgetLine(label: String, value: String, valueColor: ColorProvider) {
    Row(GlanceModifier.fillMaxWidth().padding(vertical = 1.dp)) {
        Text(
            text = "$label: ",
            style = TextStyle(color = WidgetMuted, fontSize = 11.sp)
        )
        Text(
            text = value,
            style = TextStyle(color = valueColor, fontSize = 11.sp, fontWeight = FontWeight.Bold),
            maxLines = 1
        )
    }
}

@Composable
private fun WidgetButton(label: String, destination: String, modifier: GlanceModifier) {
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
        modifier = modifier.padding(2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = WidgetPrimary,
            contentColor = ColorProvider(Color(0xFF080D13))
        )
    )
}
