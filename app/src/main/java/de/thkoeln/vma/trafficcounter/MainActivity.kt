package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.*
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme
import de.thkoeln.vma.trafficcounter.ui.screens.CounterScreen
import de.thkoeln.vma.trafficcounter.ui.screens.InfoScreen
import de.thkoeln.vma.trafficcounter.ui.screens.ListScreen


// Haupt-Activity der App
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // aktiviert Edge-to-Edge Anzeige
        setContent {
            TrafficCounterTheme {
                val navController = rememberNavController() // Navigation Controller merken

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController, // Navigation-Host setzen
                        startDestination = "counterScreen" // Startziel der Navigation
                    ) {
                        // Composables als Navigationsziele
                        composable("counterScreen") {
                            CounterScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }
                        composable("listScreen") {
                            ListScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

                        composable("InfoScreen") {
                            InfoScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }


                    }
                }
            }
        }
    }
}

// Bildschirm für Verkehrszählung


// Vorschau für Entwicklungszwecke
@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    TrafficCounterTheme {
        CounterScreen(modifier = Modifier.padding(16.dp), navController = rememberNavController())
    }
}
