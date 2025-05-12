package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.mutableStateOf

class TrafficViewModel : ViewModel() {

    val footTraffic = mutableStateOf(0)
    val cyclingTraffic = mutableStateOf(0)
    val totalTraffic = mutableStateOf(0)

    fun incrementFootTraffic() {
        footTraffic.value += 1
        totalTraffic.value += 1
    }

    fun incrementCyclingTraffic() {
        cyclingTraffic.value += 1
        totalTraffic.value += 1
    }

    fun resetCounts() {
        footTraffic.value = 0
        cyclingTraffic.value = 0
        totalTraffic.value = 0
    }


    // Brauchen Sie erst bei einer Live-Aufgabe (Pflicht), bei der Sie unsere Unterstützung bekommen
    class TrafficViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrafficViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

