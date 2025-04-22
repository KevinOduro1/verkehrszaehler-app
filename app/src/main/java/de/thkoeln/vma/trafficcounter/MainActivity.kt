package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme

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
                    }
                }
            }
        }
    }
}

// Bildschirm für Verkehrszählung
@Composable
fun CounterScreen(modifier: Modifier = Modifier, navController: NavController) {
    val footTraffic = remember { mutableStateOf(0) } // Fußgänger-Zähler
    val cyclingTraffic = remember { mutableStateOf(0) } // Fahrrad-Zähler
    val totalTraffic = remember { mutableStateOf(0) } // Gesamt-Zähler

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Fahrradverkehr: ${cyclingTraffic.value}")
        Text("Fußgängerverkehr: ${footTraffic.value}")
        Text("Gesamtverkehr: ${totalTraffic.value}")

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Button für Fußgänger-Zählung
            Button(onClick = {
                footTraffic.value += 1
                totalTraffic.value += 1
            }) {
                Text("Fußgänger:in")
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Button für Fahrrad-Zählung
            Button(onClick = {
                cyclingTraffic.value += 1
                totalTraffic.value += 1
            }) {
                Text("Fahrradfahrer:in")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Reset-Button
        Button(onClick = {
            footTraffic.value = 0
            cyclingTraffic.value = 0
            totalTraffic.value = 0
        }) {
            Text("Reset")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Navigation zur Liste
        Button(onClick = {
            navController.navigate("listScreen")
        }) {
            Text("Zur Liste")
        }
    }
}

// Bildschirm für Anzeige der Verkehrsdaten
@Composable
fun ListScreen(modifier: Modifier = Modifier, navController: NavController) {
    val traffics = SampleData.trafficSample // Beispieldaten laden

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Verkehrsdaten Liste", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            // Einzelne Verkehrseinträge anzeigen
            items(traffics) { traffic ->
                TrafficCard(traffic)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Zurück zur Zählseite
        Button(onClick = {
            navController.navigate("counterScreen")
        }) {
            Text("Zur Zählseite")
        }
    }
}

// Darstellung eines einzelnen Verkehrseintrags
@Composable
fun TrafficCard(traffic: Traffic) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text("Typ: ${traffic.trafficType}", style = MaterialTheme.typography.bodyLarge)
            Text("Datum: ${traffic.date}", style = MaterialTheme.typography.bodyMedium)
            Text("Notiz: ${traffic.note}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// Vorschau für Entwicklungszwecke
@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    TrafficCounterTheme {
        CounterScreen(modifier = Modifier.padding(16.dp), navController = rememberNavController())
    }
}
