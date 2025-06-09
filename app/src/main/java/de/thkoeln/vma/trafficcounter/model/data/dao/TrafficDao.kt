package de.thkoeln.vma.trafficcounter.model.data.dao

import androidx.room.*
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic.TrafficType
import kotlinx.coroutines.flow.Flow

@Dao
interface TrafficDao {

    @Insert
    suspend fun insertTraffic(traffic: Traffic)

    @Query("SELECT * FROM traffic")
    fun getTotalTraffic(): Flow<List<Traffic>>

    @Query("SELECT * FROM traffic WHERE trafficType = 'CYCLING'")
    fun getCyclingTraffic(): Flow<List<Traffic>>

    @Query("SELECT * FROM traffic WHERE trafficType = 'FOOT'")
    fun getFootTraffic(): Flow<List<Traffic>>

    @Query("DELETE FROM traffic")
    suspend fun deleteAllTraffic()

    @Query("SELECT * FROM traffic WHERE id = :id")
    fun getTrafficById(id: Int): Flow<Traffic>

    // Count-Funktionen
    @Query("SELECT COUNT(*) FROM traffic") //Gesamtverkehr
    fun getTotalTrafficCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM traffic WHERE trafficType = 0") //CYCLING
    fun getCyclingTrafficCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM traffic WHERE trafficType = 1") //FOOT
    fun getFootTrafficCount(): Flow<Int>
}
