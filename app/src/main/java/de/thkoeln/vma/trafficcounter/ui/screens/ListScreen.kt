package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    trafficViewModel: TrafficViewModel
) {
    val traffics by trafficViewModel.totalTraffic.collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Verkehrsdaten Liste", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(traffics) { traffic ->
                TrafficCard(traffic)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun TrafficCard(traffic: Traffic) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text("Typ: ${traffic.trafficType}", style = MaterialTheme.typography.bodyLarge)
            Text("Datum: ${traffic.date}", style = MaterialTheme.typography.bodyMedium)
            Text("Notiz: ${traffic.note}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
