package de.thkoeln.vma.trafficcounter.ui.components


import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List

import androidx.compose.material3.Icon

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController



@Composable
fun TrafficBottomNavigationBar(navController: NavController) {



        NavigationBar (modifier = Modifier.height(80.dp),
            containerColor = Color.Cyan
        ){
            // NavigationBarItem für den CounterScreen


            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "CounterScreen") },
                label = { Text("Counter") },
                selected = false, // für Logok falls notig
                onClick = {
                    // Navigiert zum CounterScreen
                    navController.navigate("CounterScreen")
                }
            )



            // NavigationBarItem für den ListScreen
            NavigationBarItem(
                icon = { Icon(Icons.Filled.List, contentDescription = "ListScreen") },
                label = { Text("List") },
                selected = false, // Logik
                onClick = {
                    // Navigiert zum ListScreen
                    navController.navigate("ListScreen")

                }
            )
        }


}


