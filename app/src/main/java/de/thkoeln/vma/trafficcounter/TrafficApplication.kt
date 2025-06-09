package de.thkoeln.vma.trafficcounter

import android.app.Application
import de.thkoeln.vma.trafficcounter.repository.TrafficRepository
import de.thkoeln.vma.trafficcounter.model.data.database.TrafficDatabase

class TrafficApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
    val database by lazy { TrafficDatabase.getDatabase(this) }
    val repository by lazy { TrafficRepository(database.trafficDao()) }
}