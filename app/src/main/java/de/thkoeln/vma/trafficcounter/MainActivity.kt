package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*


import androidx.compose.material3.*

import androidx.compose.ui.Modifier



import androidx.navigation.compose.*
<<<<<<< HEAD

=======
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme
import de.thkoeln.vma.trafficcounter.ui.screens.CounterScreen
import de.thkoeln.vma.trafficcounter.ui.screens.InfoScreen
import de.thkoeln.vma.trafficcounter.ui.screens.ListScreen
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar



import androidx.lifecycle.viewmodel.compose.viewModel


import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel


import androidx.activity.viewModels
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

// Haupt-Activity der App
class MainActivity : ComponentActivity() {

<<<<<<< HEAD

=======
    private val trafficViewModel: TrafficViewModel by viewModels {
        TrafficViewModel.TrafficViewModelFactory()
    }
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // aktiviert Edge-to-Edge Anzeige
        setContent {
            TrafficCounterTheme {
                val navController = rememberNavController() // Navigation Controller merken

<<<<<<< HEAD
                // Holen des ViewModels
                val trafficViewModel: TrafficViewModel = viewModel(
                    factory = TrafficViewModel.TrafficViewModelFactory()
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { TrafficBottomNavigationBar(navController) },
                    topBar = { TrafficTopAppBar(navController = navController) }
                ) { innerPadding ->
=======
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TrafficTopAppBar(navController = navController)
                    },
                    bottomBar = { TrafficBottomNavigationBar(navController = navController) }) { innerPadding ->
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
                    NavHost(
                        navController = navController, // Navigation-Host setzen
                        startDestination = "counterScreen" // Startziel der Navigation
                    ) {

                        composable("counterScreen") {
<<<<<<< HEAD
                            // Übergabe des trafficViewModel an CounterScreen
                            CounterScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                trafficViewModel = trafficViewModel // Hier wird das ViewModel übergeben
                            )
=======
                            CounterScreen(modifier = Modifier.padding(innerPadding), navController = navController, trafficViewModel = trafficViewModel)
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
                        }
                        composable("listScreen") {
                            ListScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

                        composable("InfoScreen") {
                            InfoScreen(modifier = Modifier.padding(innerPadding), navController = navController)
                        }

<<<<<<< HEAD
                        composable("TrafficBottomNavigationBar") {
                            TrafficBottomNavigationBar(navController = navController)
                        }
=======
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
                    }
                }
            }
        }

    }
}


// Vorschau für Entwicklungszwecke
<<<<<<< HEAD

=======
@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    TrafficCounterTheme {
        CounterScreen(modifier = Modifier.padding(16.dp), navController = rememberNavController(), trafficViewModel = TrafficViewModel())
    }
}
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
