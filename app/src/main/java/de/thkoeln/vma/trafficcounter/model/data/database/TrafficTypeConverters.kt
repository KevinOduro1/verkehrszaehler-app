package de.thkoeln.vma.trafficcounter.model.data.database

import androidx.room.TypeConverter
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class TrafficTypeConverters {

    @TypeConverter
    fun fromTrafficType(trafficType: Traffic.TrafficType): Int {
        return trafficType.ordinal
    }

    @TypeConverter
    fun toTrafficType(value: Int): Traffic.TrafficType {
        return Traffic.TrafficType.entries[value]
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return value?.let {
            LocalDateTime.ofInstant(Instant.ofEpochMilli(it), ZoneId.systemDefault())
        }
    }

    @TypeConverter
    fun toTimestamp(date: LocalDateTime?): Long? {
        return date?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }
}
