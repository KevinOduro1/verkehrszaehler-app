package de.thkoeln.vma.trafficcounter.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import de.thkoeln.vma.trafficcounter.model.data.dao.TrafficDao
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic

@Database(entities = [Traffic::class], version = 1, exportSchema = false)
@TypeConverters(TrafficTypeConverters::class)
abstract class TrafficDatabase : RoomDatabase() {

    abstract fun trafficDao(): TrafficDao

    companion object {
        @Volatile
        private var INSTANCE: TrafficDatabase? = null

        fun getDatabase(context: Context): TrafficDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrafficDatabase::class.java,
                    "traffic_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
