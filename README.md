# Lab14Widgets — Panel Logístico

**Laboratorio 14: Widgets**

Aplicación Android para consultar y controlar un carrito logístico automatizado que transporta cargas y registra entradas, salidas y movimientos. Toda la información se obtiene de datos simulados locales.

## Tecnologías

- Kotlin
- Jetpack Compose y Material 3
- Jetpack Glance 1.1.0
- Android SDK 34 (`minSdk 24`, `targetSdk 34`)
- Gradle 8.7

## Funcionalidades

- Panel de inicio con estado, carga, ubicación, batería y operación actual.
- Registro local de cargas ingresadas y despachadas.
- Historial de movimientos del carrito.
- Navegación inferior entre Inicio, Entradas, Salidas e Historial.
- Interfaz tecnológica e industrial adaptable.

## Widget

El widget **Panel Logístico** resume el estado del carrito desde la pantalla de inicio. Su contenido se adapta al espacio disponible:

- Pequeño: estado, batería y accesos a Entradas y Salidas.
- Mediano: estado, carga, ubicación, métricas, batería y accesos principales.
- Grande: información completa, último movimiento, próximo destino, sistema y cuatro accesos directos.

Cada botón abre directamente la vista correspondiente mediante un `Intent` con el extra `destination` (`home`, `entries`, `exits` o `history`).

## Ejecutar la aplicación

1. Abrir la carpeta del proyecto en Android Studio.
2. Confirmar que el SDK de Android 34 esté instalado.
3. Sincronizar el proyecto con Gradle.
4. Crear o seleccionar un emulador con Android 7.0 (API 24) o superior.
5. Ejecutar la configuración `app`.

También se puede compilar desde PowerShell:

```powershell
.\gradlew.bat :app:assembleDebug --no-daemon
```

## Agregar el widget al emulador

1. Instalar y abrir la aplicación al menos una vez.
2. Mantener presionada una zona vacía de la pantalla de inicio.
3. Seleccionar **Widgets**.
4. Buscar **Panel Logístico**.
5. Arrastrar el widget a la pantalla y ajustar su tamaño para probar sus tres presentaciones.

## Evidencias

### Capturas

> Agregar aquí capturas de Inicio, Entradas, Salidas, Historial y los tamaños del widget.

### Video

> Agregar aquí el enlace al video de demostración.

## Informe

### Objetivo

Desarrollar un widget de pantalla de inicio con Jetpack Glance para consultar información del carrito logístico y acceder rápidamente a sus funciones principales.

### Desarrollo

Se creó una aplicación con varias vistas para controlar las entradas, salidas, historial y estado del carrito. El widget muestra información relevante y permite ingresar directamente a cada sección.

### Resultado

La aplicación y el widget funcionan correctamente, muestran información clara y facilitan el control del proceso logístico.

### Reflexión

Los widgets permiten consultar información importante sin abrir toda la aplicación. Esto ahorra tiempo y hace que el sistema sea más práctico, rápido y eficiente.

### Pregunta de observación

La parte más desafiante fue lograr que cada botón del widget abriera directamente una pantalla diferente. Se resolvió utilizando `Intent` y parámetros para identificar cada destino.

La IA fue utilizada como apoyo para organizar el código, corregir errores, mejorar el diseño y verificar que el proyecto compilara correctamente.

## Repositorio

https://github.com/mzl-commits/lab14
