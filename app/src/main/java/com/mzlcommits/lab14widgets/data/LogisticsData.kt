package com.mzlcommits.lab14widgets.data

data class EntryLoad(val code: String, val weight: String, val time: String, val status: String)
data class ExitLoad(val code: String, val destination: String, val time: String, val status: String)
data class Movement(val title: String, val detail: String)

object LogisticsData {
    const val cartStatus = "Operativo"
    const val currentLoad = "Caja A-102"
    const val weight = "18 kg"
    const val location = "Zona de despacho"
    const val battery = "82 %"
    const val entriesToday = "5"
    const val exitsToday = "4"
    const val lastMovement = "Entrega completada"
    const val nextDestination = "Almacén B"
    const val systemStatus = "Sin alertas"

    val entries = listOf(
        EntryLoad("Caja A-102", "18 kg", "08:30", "Registrada"),
        EntryLoad("Paquete B-205", "12 kg", "09:10", "En transporte"),
        EntryLoad("Carga C-310", "24 kg", "10:00", "Registrada")
    )

    val exits = listOf(
        ExitLoad("Caja X-001", "Almacén A", "08:45", "Entregada"),
        ExitLoad("Paquete Y-120", "Almacén B", "09:40", "Entregada"),
        ExitLoad("Carga Z-500", "Zona de despacho", "10:20", "Pendiente")
    )

    val movements = listOf(
        Movement("Entrada de carga registrada", "08:30 · Caja A-102"),
        Movement("Transporte iniciado", "08:36 · Ruta hacia despacho"),
        Movement("Carga entregada", "08:45 · Almacén A"),
        Movement("Retorno al punto inicial", "08:52 · Base logística")
    )
}

