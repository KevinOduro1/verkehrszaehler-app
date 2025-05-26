package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

@Composable
fun CounterScreen(
    trafficViewModel: TrafficViewModel,
    navController: NavController,
    onResetClicked: () -> Unit, // <-- neu
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Gesamtverkehr: ${trafficViewModel.totalTraffic}",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Fußgänger: ${trafficViewModel.footTraffic}",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Fahrradfahrer: ${trafficViewModel.cyclingTraffic}",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onResetClicked() }, // <-- statt direkt resetCounters()
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reset", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { trafficViewModel.increaseFootTraffic() },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Fußgänger", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { trafficViewModel.increaseCyclingTraffic() },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Fahrradfahrer", color = Color.Black)
            }
        }
    }
}
