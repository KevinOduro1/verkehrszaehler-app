package de.thkoeln.vma.trafficcounter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic.TrafficType
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel
import java.time.LocalDateTime

@Composable
fun CounterScreen(
    trafficViewModel: TrafficViewModel,
    navController: NavController,
    onResetClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Live-Zählwerte aus DB (Flows) sammeln
    val totalCount by trafficViewModel.totalTrafficCount.collectAsState(initial = 0)
    val footCount by trafficViewModel.footTrafficCount.collectAsState(initial = 0)
    val cyclingCount by trafficViewModel.cyclingTrafficCount.collectAsState(initial = 0)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Gesamtverkehr: $totalCount",
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
                text = "Fußgänger: $footCount",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Fahrradfahrer: $cyclingCount",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onResetClicked,
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reset", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    trafficViewModel.insertTraffic(
                        Traffic(
                            trafficType = TrafficType.FOOT,
                            date = LocalDateTime.now(),
                            note = "Zählung Fußgänger"
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Fußgänger", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    trafficViewModel.insertTraffic(
                        Traffic(
                            trafficType = TrafficType.CYCLING,
                            date = LocalDateTime.now(),
                            note = "Zählung Fahrrad"
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(Color.Cyan),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Fahrradfahrer", color = Color.Black)
            }
        }
    }
}
