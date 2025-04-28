package de.thkoeln.vma.trafficcounter.ui.screens

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

       Row (modifier = Modifier.fillMaxWidth()){
           Text(
               text = "Gesamtverkehr:${totalTraffic.value}",
               textAlign = TextAlign.Center,
               modifier = Modifier
                   .fillMaxWidth()
                   .clip(RoundedCornerShape(8.dp))
                   .background(MaterialTheme.colorScheme.background)
                   .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                   .padding(8.dp)
           )

       }
        Spacer(modifier = Modifier.width(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Fußgängerverkehr: ${footTraffic.value}",
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
                text = "Fahrradfahrer: ${cyclingTraffic.value}",
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
                footTraffic.value = 0
                cyclingTraffic.value = 0
                totalTraffic.value = 0
            },
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
                onClick = {
                    footTraffic.value += 1
                    totalTraffic.value += 1
                },
                modifier = Modifier.weight(1f) // Der Button nimmt 1/2 des verfügbaren Platzes ein
            ) {
                Text("Fußgänger")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    cyclingTraffic.value += 1
                    totalTraffic.value += 1
                },
                modifier = Modifier.weight(1f) // Der Button nimmt 1/2 des verfügbaren Platzes ein
            ) {
                Text("Fahrradfahrer")
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        // Reset-Button




        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("listScreen")
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd)  // Positioniert den Button am rechten Rand
                    .padding(16.dp)  // Optional, um zusätzlichen Abstand zu geben
            ) {
                Text("Zur Liste")
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate("InfoScreen")
        }) {
            Text("InfoScreen")
        }

    }


}
