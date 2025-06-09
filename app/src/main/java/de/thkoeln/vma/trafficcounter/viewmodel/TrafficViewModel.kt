package de.thkoeln.vma.trafficcounter.viewmodel

import androidx.lifecycle.*
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import de.thkoeln.vma.trafficcounter.repository.TrafficRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.annotation.WorkerThread

class TrafficViewModel(private val repository: TrafficRepository) : ViewModel() {

    // Flow-Listen
    val totalTraffic: Flow<List<Traffic>> = repository.totalTraffic
    val footTraffic: Flow<List<Traffic>> = repository.footTraffic
    val cyclingTraffic: Flow<List<Traffic>> = repository.cyclingTraffic

    // 🟢 Zähler-Flows
    val totalTrafficCount: Flow<Int> = repository.totalTrafficCount
    val footTrafficCount: Flow<Int> = repository.footTrafficCount
    val cyclingTrafficCount: Flow<Int> = repository.cyclingTrafficCount

    // Methoden für DB-Operationen
    @WorkerThread
    fun insertTraffic(traffic: Traffic) = viewModelScope.launch {
        repository.insertTraffic(traffic)
    }

    @WorkerThread
    fun deleteAllTraffic() = viewModelScope.launch {
        repository.deleteAllTraffic()
    }

    // Factory-Klasse
    class TrafficViewModelFactory(private val repository: TrafficRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TrafficViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TrafficViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
