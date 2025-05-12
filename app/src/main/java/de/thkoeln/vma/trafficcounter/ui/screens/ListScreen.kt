package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.SampleData
import de.thkoeln.vma.trafficcounter.Traffic

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