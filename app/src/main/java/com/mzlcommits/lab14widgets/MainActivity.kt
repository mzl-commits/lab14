package com.mzlcommits.lab14widgets

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import com.mzlcommits.lab14widgets.ui.LogisticsApp
import com.mzlcommits.lab14widgets.ui.destinationFromValue
import com.mzlcommits.lab14widgets.ui.theme.Lab14WidgetsTheme

class MainActivity : ComponentActivity() {
    private val requestedDestination = mutableStateOf(destinationFromValue(null))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedDestination.value = destinationFromValue(intent.getStringExtra(EXTRA_DESTINATION))
        setContent {
            Lab14WidgetsTheme {
                LogisticsApp(initialDestination = requestedDestination.value)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        requestedDestination.value = destinationFromValue(intent.getStringExtra(EXTRA_DESTINATION))
    }

    companion object {
        const val EXTRA_DESTINATION = "destination"
    }
}
