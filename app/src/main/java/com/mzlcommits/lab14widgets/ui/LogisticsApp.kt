package com.mzlcommits.lab14widgets.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

enum class Destination(val label: String) {
    HOME("Inicio"),
    ENTRIES("Entradas"),
    EXITS("Salidas"),
    HISTORY("Historial")
}

fun destinationFromValue(value: String?): Destination = when (value) {
    "entries" -> Destination.ENTRIES
    "exits" -> Destination.EXITS
    "history" -> Destination.HISTORY
    else -> Destination.HOME
}

@Composable
fun LogisticsApp(initialDestination: Destination = Destination.HOME) {
    var destination by remember(initialDestination) { mutableStateOf(initialDestination) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                Destination.entries.forEach { item ->
                    NavigationBarItem(
                        selected = destination == item,
                        onClick = { destination = item },
                        icon = { Text(item.label.take(1)) },
                        label = { Text(item.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.background,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
        }
    ) { padding ->
        when (destination) {
            Destination.HOME -> HomeScreen(Modifier.padding(padding))
            Destination.ENTRIES -> EntriesScreen(Modifier.padding(padding))
            Destination.EXITS -> ExitsScreen(Modifier.padding(padding))
            Destination.HISTORY -> HistoryScreen(Modifier.padding(padding))
        }
    }
}
