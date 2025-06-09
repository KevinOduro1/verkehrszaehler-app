package de.thkoeln.vma.trafficcounter.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import de.thkoeln.vma.trafficcounter.model.data.database.TrafficDatabase
import de.thkoeln.vma.trafficcounter.repository.TrafficRepository
import de.thkoeln.vma.trafficcounter.ui.components.CleanDatabaseDialog
import de.thkoeln.vma.trafficcounter.ui.components.TrafficBottomNavigationBar
import de.thkoeln.vma.trafficcounter.ui.components.TrafficTopAppBar
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel


@Composable
fun MainScreen(trafficViewModel: TrafficViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val db = TrafficDatabase.getDatabase(context)
    val repository = TrafficRepository(db.trafficDao())
    val trafficViewModel: TrafficViewModel = viewModel(
        factory = TrafficViewModel.TrafficViewModelFactory(repository)
    )

    var showDialog by remember { mutableStateOf(false) }

    CleanDatabaseDialog(
        showDialog = showDialog,
        onDismissRequest = { showDialog = false },
        onConfirmation = {
            trafficViewModel.deleteAllTraffic()
            showDialog = false
        },
        dialogTitle = "DB löschen?",
        dialogText = "Möchtest du wirklich alle Verkehrszähler zurücksetzen?",
        icon = Icons.Filled.Delete
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { TrafficBottomNavigationBar(navController) },
        topBar = { TrafficTopAppBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "counterScreen"
        ) {
            composable("counterScreen") {
                CounterScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    trafficViewModel = trafficViewModel,
                    onResetClicked = { showDialog = true }
                )
            }
            composable("listScreen") {
                ListScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    trafficViewModel = trafficViewModel
                )

            }
            composable("InfoScreen") {
                InfoScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }
    }
}
