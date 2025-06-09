package de.thkoeln.vma.trafficcounter.model.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "traffic")
data class Traffic(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
) {
    enum class TrafficType {
        CYCLING, FOOT
    }
}
