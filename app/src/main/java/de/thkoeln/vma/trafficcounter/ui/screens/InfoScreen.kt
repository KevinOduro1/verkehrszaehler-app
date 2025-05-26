package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun InfoScreen (modifier: Modifier = Modifier, navController: NavController) {
    val traffics = SampleData.trafficSample

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Student 1:", style = MaterialTheme.typography.bodyLarge)
        Text("Kevin", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Student 2:", style = MaterialTheme.typography.bodyLarge)
        Text("Maher", style = MaterialTheme.typography.headlineMedium)
    }

}