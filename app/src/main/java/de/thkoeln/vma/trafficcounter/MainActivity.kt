package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*


import androidx.compose.material3.*

import androidx.compose.ui.Modifier



import androidx.navigation.compose.*

import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme
import de.thkoeln.vma.trafficcounter.ui.screens.CounterScreen
import de.thkoeln.vma.trafficcounter.ui.screens.InfoScreen
import de.thkoeln.vma.trafficcounter.ui.screens.ListScreen
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar



import androidx.lifecycle.viewmodel.compose.viewModel


import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel



// Haupt-Activity der App
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // aktiviert Edge-to-Edge Anzeige
        setContent {
            TrafficCounterTheme {
                val navController = rememberNavController() // Navigation Controller merken

                // Holen des ViewModels
                val trafficViewModel: TrafficViewModel = viewModel(
                    factory = TrafficViewModel.TrafficViewModelFactory()
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { TrafficBottomNavigationBar(navController) },
                    topBar = { TrafficTopAppBar(navController = navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController, // Navigation-Host setzen
                        startDestination = "counterScreen" // Startziel der Navigation
                    ) {

                        composable("counterScreen") {
                            // Übergabe des trafficViewModel an CounterScreen
                            CounterScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                trafficViewModel = trafficViewModel // Hier wird das ViewModel übergeben
                            )
                        }
                        composable("listScreen") {
                            ListScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

                        composable("InfoScreen") {
                            InfoScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

                        composable("TrafficBottomNavigationBar") {
                            TrafficBottomNavigationBar(navController = navController)
                        }
                    }
                }
            }
        }

    }
}

// Bildschirm für Verkehrszählung


// Vorschau für Entwicklungszwecke

