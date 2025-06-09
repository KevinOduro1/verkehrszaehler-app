package de.thkoeln.vma.trafficcounter.repository

import androidx.annotation.WorkerThread
import de.thkoeln.vma.trafficcounter.model.data.dao.TrafficDao
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import kotlinx.coroutines.flow.Flow

class TrafficRepository(private val trafficDao: TrafficDao) {

    val totalTraffic: Flow<List<Traffic>> = trafficDao.getTotalTraffic()
    val footTraffic: Flow<List<Traffic>> = trafficDao.getFootTraffic()
    val cyclingTraffic: Flow<List<Traffic>> = trafficDao.getCyclingTraffic()

    val totalTrafficCount: Flow<Int> = trafficDao.getTotalTrafficCount()
    val footTrafficCount: Flow<Int> = trafficDao.getFootTrafficCount()
    val cyclingTrafficCount: Flow<Int> = trafficDao.getCyclingTrafficCount()

    @WorkerThread
    suspend fun insertTraffic(traffic: Traffic) {
        trafficDao.insertTraffic(traffic)
    }

    @WorkerThread
    suspend fun deleteAllTraffic() {
        trafficDao.deleteAllTraffic()
    }
}
