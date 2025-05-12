package de.thkoeln.vma.trafficcounter.ui.screens

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel
<<<<<<< HEAD


@Composable
fun CounterScreen(trafficViewModel: TrafficViewModel, navController: NavController, modifier: Modifier = Modifier) {



=======

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    trafficViewModel: TrafficViewModel
) {
    val footTraffic = trafficViewModel.footTraffic
    val cyclingTraffic = trafficViewModel.cyclingTraffic
    val totalTraffic = trafficViewModel.totalTraffic

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Gesamtverkehr: ${totalTraffic.value}",
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
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40


        Column(
            modifier = modifier
                .fillMaxSize() // gesammte oberfäche nehmen
                .padding(16.dp) // die entfernung der elemte von rändern
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Gesamtverkehr:${trafficViewModel.totalTraffic}",
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

            Row(
                modifier = Modifier
<<<<<<< HEAD
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Fußgänger: ${trafficViewModel.footTraffic}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f) // das die sich gleich gewicht aufteilen
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
                onClick = {
                    trafficViewModel.resetCounters()

                }, colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Reset",
                    color = Color.Black
                )
            }


            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()


            ) {
                Button(
                    onClick = {
                       trafficViewModel.increaseFootTraffic() //

                    }, colors = ButtonDefaults.buttonColors(Color.Cyan),
                    modifier = Modifier.weight(1f) // Der Button nimmt 1/2 des verfügbaren Platzes ein
                ) {
                    Text(
                        text = "Füßgängeer",
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                       trafficViewModel.increaseCyclingTraffic() //

                    }, colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                    modifier = Modifier.weight(1f) // Der Button nimmt 1/2 des verfügbaren Platzes ein
                ) {
                    Text(
                        text = "Fahrradfahrer",
                        color = Color.Black
                    )
                }
=======
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Fahrradfahrer: ${cyclingTraffic.value}",
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
            onClick = { trafficViewModel.resetCounts() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = { trafficViewModel.incrementFootTraffic() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Fußgänger")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { trafficViewModel.incrementCyclingTraffic() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Fahrradfahrer")
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
            }


            Spacer(modifier = Modifier.height(8.dp))

            // Reset-Button





          /*  Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("InfoScreen")
            }) {
                Text("InfoScreen")
            }*/


        }

<<<<<<< HEAD




=======
        Spacer(modifier = Modifier.height(8.dp))
    }
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
}
