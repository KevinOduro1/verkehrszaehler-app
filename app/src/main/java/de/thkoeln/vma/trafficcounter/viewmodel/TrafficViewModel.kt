package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class TrafficViewModel : ViewModel() {





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
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrafficViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}