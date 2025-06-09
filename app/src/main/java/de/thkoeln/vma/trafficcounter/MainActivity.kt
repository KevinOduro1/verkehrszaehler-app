package de.thkoeln.vma.trafficcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import de.thkoeln.vma.trafficcounter.ui.screens.MainScreen
import de.thkoeln.vma.trafficcounter.viewmodel.TrafficViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: TrafficViewModel by viewModels {
        TrafficViewModel.TrafficViewModelFactory((application as TrafficApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(trafficViewModel = viewModel)
        }
    }
}
