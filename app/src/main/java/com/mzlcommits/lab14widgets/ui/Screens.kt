package com.mzlcommits.lab14widgets.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mzlcommits.lab14widgets.data.LogisticsData
import com.mzlcommits.lab14widgets.ui.theme.Success
import com.mzlcommits.lab14widgets.ui.theme.Warning

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(horizontal = 18.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle("PANEL LOGÍSTICO", "MONITOR DE OPERACIÓN · EN LÍNEA") }
        item {
            StatusCard(
                label = "ESTADO DEL CARRITO",
                value = LogisticsData.cartStatus,
                supporting = "Unidad lista para operación",
                accent = Success
            )
        }
        item { InfoCard("CARGA ACTUAL", LogisticsData.currentLoad, LogisticsData.weight) }
        item { InfoCard("UBICACIÓN", LogisticsData.location, "Posición confirmada") }
        item { InfoCard("NIVEL DE BATERÍA", LogisticsData.battery, "Autonomía estable") }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MetricCard("ENTRADAS", LogisticsData.entriesToday, Modifier.weight(1f))
                MetricCard("SALIDAS", LogisticsData.exitsToday, Modifier.weight(1f))
            }
        }
        item { InfoCard("ÚLTIMO MOVIMIENTO", LogisticsData.lastMovement, "Registro actualizado") }
        item { InfoCard("PRÓXIMO DESTINO", LogisticsData.nextDestination, "Ruta programada") }
        item {
            StatusCard(
                label = "ESTADO DEL SISTEMA",
                value = LogisticsData.systemStatus,
                supporting = "Sensores y navegación normales",
                accent = Success
            )
        }
    }
}

@Composable
fun EntriesScreen(modifier: Modifier = Modifier) {
    RecordsScreen(
        title = "ENTRADAS",
        subtitle = "CARGAS INGRESADAS HOY · ${LogisticsData.entriesToday}",
        modifier = modifier
    ) {
        items(LogisticsData.entries) { load ->
            RecordCard(load.code, "${load.weight}  /  ${load.time}", load.status)
        }
    }
}

@Composable
fun ExitsScreen(modifier: Modifier = Modifier) {
    RecordsScreen(
        title = "SALIDAS",
        subtitle = "CARGAS DESPACHADAS HOY · ${LogisticsData.exitsToday}",
        modifier = modifier
    ) {
        items(LogisticsData.exits) { load ->
            RecordCard(load.code, "${load.destination}  /  ${load.time}", load.status)
        }
    }
}

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {
    RecordsScreen(
        title = "HISTORIAL",
        subtitle = "TRAZABILIDAD DE MOVIMIENTOS",
        modifier = modifier
    ) {
        items(LogisticsData.movements) { movement ->
            RecordCard(movement.title, movement.detail, "Completado")
        }
    }
}

@Composable
private fun RecordsScreen(
    title: String,
    subtitle: String,
    modifier: Modifier,
    content: androidx.compose.foundation.lazy.LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(horizontal = 18.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle(title, subtitle) }
        content()
    }
}

@Composable
private fun ScreenTitle(title: String, subtitle: String) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            title,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Black,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            subtitle,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
private fun StatusCard(label: String, value: String, supporting: String, accent: Color) {
    IndustrialCard {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.labelMedium)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(value, color = accent, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            StatusPill("ACTIVO", accent)
        }
        Text(supporting, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun InfoCard(label: String, value: String, supporting: String) {
    IndustrialCard {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.labelMedium)
        Text(value, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.titleMedium)
        Text(supporting, color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun MetricCard(label: String, value: String, modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.labelMedium)
            Text(value, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Black, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Composable
private fun RecordCard(title: String, detail: String, status: String) {
    IndustrialCard {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            StatusPill(status.uppercase(), if (status == "Pendiente") Warning else Success)
        }
        Text(detail, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun IndustrialCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            Modifier.fillMaxWidth().padding(17.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            content = content
        )
    }
}

@Composable
private fun StatusPill(text: String, color: Color) {
    Box(
        Modifier
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = 0.16f))
            .padding(horizontal = 9.dp, vertical = 5.dp)
    ) {
        Text(text, color = color, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)
    }
}
