package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.thkoeln.vma.trafficcounter.ui.theme.TrafficCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrafficCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Greeting( name = "Android", modifier = Modifier.padding(innerPadding)  )

                    // Wird erst bei Aufgabe A 1.3 gebraucht. Bitte erst DANN einkommentieren.
                    //
                    /*
                    val navController = rememberNavController() // NavController besorgen
                    NavHost(navController = navController, startDestination = "counterScreen") {
                        composable("counterScreen") { CounterScreen(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController) }    // Der NavController muss ab Zettel 2 nicht mehr übergeben werden
                        composable("listScreen") { ListScreen(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController) }    // Der NavController muss ab Zettel 2 nicht mehr übergeben werden
                    }
                    */
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrafficCounterTheme {
        Greeting("Android")
    }
}