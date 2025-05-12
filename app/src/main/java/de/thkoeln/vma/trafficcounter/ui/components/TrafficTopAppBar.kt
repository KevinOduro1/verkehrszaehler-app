package de.thkoeln.vma.trafficcounter.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrafficTopAppBar(navController: NavController) {
    val context = LocalContext.current

    CenterAlignedTopAppBar(
        title = {
            Text(text = "Traffic Counter")
        },
        actions = {
            TopAppBarMenu(
                onNavigate = { route -> navController.navigate(route) },
                onOpenTHKoeln = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.th-koeln.de"))
                    context.startActivity(intent)
                }
            )
        }
    )
}

@Composable
fun RowScope.TopAppBarMenu(
    onNavigate: (String) -> Unit,
    onOpenTHKoeln: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Mehr Optionen")
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Zum Counter Screen") },
            onClick = {
                expanded = false
                onNavigate("counterScreen") // gleiche Route wie in MainActivity
            }
        )
        DropdownMenuItem(
            text = { Text("Zur Liste") },
            onClick = {
                expanded = false
                onNavigate("listScreen")
            }
        )
        DropdownMenuItem(
            text = { Text("TH Köln Website") },
            onClick = {
                expanded = false
                onOpenTHKoeln()
            }
        )
        DropdownMenuItem(
            text = { Text("Info") },
            onClick = {
                expanded = false
                onNavigate("InfoScreen")
            }
        )
    }
}
