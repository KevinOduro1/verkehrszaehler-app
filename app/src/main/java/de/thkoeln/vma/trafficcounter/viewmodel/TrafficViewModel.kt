package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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


<<<<<<< HEAD


        var footTraffic by mutableStateOf(0)
        var cyclingTraffic by mutableStateOf(0)
        var totalTraffic by mutableStateOf(0)

        // Methode zum Zurücksetzen der Zähler
        fun resetCounters() {
            footTraffic = 0
            cyclingTraffic = 0
            totalTraffic = 0
        }

        // Methode zum Erhöhen des Fußgängerverkehrs
        fun increaseFootTraffic() {
            footTraffic += 1
            totalTraffic += 1
        }

        // Methode zum Erhöhen des Fahrradverkehrs
        fun increaseCyclingTraffic() {
            cyclingTraffic += 1
            totalTraffic += 1
        }




        // Brauchen Sie erst bei einer Live-Aufgabe (Pflicht), bei der Sie unsere Unterstützung bekommen
        class TrafficViewModelFactory() : ViewModelProvider.Factory {
=======
    // Brauchen Sie erst bei einer Live-Aufgabe (Pflicht), bei der Sie unsere Unterstützung bekommen
    class TrafficViewModelFactory() : ViewModelProvider.Factory {
>>>>>>> ebec794873f31d531e4cc45a13c346ad65d4db40
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrafficViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

