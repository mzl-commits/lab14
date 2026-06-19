package com.mzlcommits.lab14widgets.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mzlcommits.lab14widgets.data.LogisticsData

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle("Inicio", "Estado general del carrito") }
        item { InfoCard("Estado del carrito", LogisticsData.cartStatus) }
        item { InfoCard("Carga actual", "${LogisticsData.currentLoad} · ${LogisticsData.weight}") }
        item { InfoCard("Ubicación", LogisticsData.location) }
        item { InfoCard("Nivel de batería", LogisticsData.battery) }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                InfoCard("Entradas de hoy", LogisticsData.entriesToday, Modifier.weight(1f))
                InfoCard("Salidas de hoy", LogisticsData.exitsToday, Modifier.weight(1f))
            }
        }
        item { InfoCard("Último movimiento", LogisticsData.lastMovement) }
        item { InfoCard("Próximo destino", LogisticsData.nextDestination) }
        item { InfoCard("Estado del sistema", LogisticsData.systemStatus) }
    }
}

@Composable
fun EntriesScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle("Entradas", "Cargas ingresadas hoy") }
        items(LogisticsData.entries) { load ->
            RecordCard(load.code, "${load.weight} · ${load.time}", load.status)
        }
    }
}

@Composable
fun ExitsScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle("Salidas", "Cargas despachadas hoy") }
        items(LogisticsData.exits) { load ->
            RecordCard(load.code, "${load.destination} · ${load.time}", load.status)
        }
    }
}

@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ScreenTitle("Historial", "Secuencia reciente de movimientos") }
        items(LogisticsData.movements) { movement ->
            RecordCard(movement.title, movement.detail, "Completado")
        }
    }
}

@Composable
private fun ScreenTitle(title: String, subtitle: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(title, style = MaterialTheme.typography.headlineLarge)
        Text(subtitle, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun InfoCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(label, style = MaterialTheme.typography.labelLarge)
            Text(value, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
private fun RecordCard(title: String, detail: String, status: String) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(detail, style = MaterialTheme.typography.bodyMedium)
            Text(status, style = MaterialTheme.typography.labelLarge)
        }
    }
}
