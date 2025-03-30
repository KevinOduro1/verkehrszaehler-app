package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrafficViewModel : ViewModel() {







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