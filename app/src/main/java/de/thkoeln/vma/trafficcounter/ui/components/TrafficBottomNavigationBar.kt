package de.thkoeln.vma.trafficcounter.ui.components

<<<<<<< HEAD

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


=======
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun TrafficBottomNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    val items = listOf(
        BottomNavItem("counterScreen", "Zähler", Icons.Default.Home),
        BottomNavItem("listScreen", "Auswertung", Icons.Default.List)
    )

    NavigationBar(modifier = modifier) {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo("counterScreen") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

data class BottomNavItem(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
