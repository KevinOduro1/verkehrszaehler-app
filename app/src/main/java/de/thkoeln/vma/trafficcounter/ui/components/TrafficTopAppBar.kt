package de.thkoeln.vma.trafficcounter.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TrafficTopAppBar(modifier: Modifier = Modifier,navController: NavController ) {
    var expanded by remember { mutableStateOf(false) }

    // Holen des Contexts
    val context = LocalContext.current

    // TopAppBar für Material Design 2
    TopAppBar(

        backgroundColor = Color.Cyan,
        title = {
            Text(
                text = "Traffic App",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp)


        },

        actions = {
            Box {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "More options")
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    DropdownMenuItem(onClick = {
                        navController.navigate("CounterScreen")
                        expanded = false
                    }) {
                        Text("CounterScreen")
                    }
                    DropdownMenuItem(onClick = {
                        navController.navigate("ListScreen")
                        expanded = false
                    }) {
                        Text("ListScreen")
                    }
                    DropdownMenuItem(onClick = {
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse("https://www.th-koeln.de")
                        }
                        context.startActivity(intent)
                        expanded = false
                    }) {
                        Text("TH-Köln Website")
                    }
                    DropdownMenuItem(onClick = {
                        navController.navigate("InfoScreen")
                        expanded = false
                    }) {
                        Text("InfoScreen")
                    }
                }
            }

        }
    )
}



