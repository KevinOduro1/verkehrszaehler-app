package de.thkoeln.vma.trafficcounter

import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import java.time.LocalDateTime

/**
 * SampleData for TrafficCounter
 */
object SampleData {
    val trafficSample = listOf(
        Traffic(
            3,
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 3),
            "Haupteingang"
        ),
        Traffic(
            7,
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 6),
            "Haupteingang"
        ),
        Traffic(
            3,
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 7),
            "Haupteingang"
        ),
        Traffic(
            2,
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 10),
            "Haupteingang"
        ),
        Traffic(4,
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 16),
            "Haupteingang"
        ),
        Traffic(5,
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 18),
            "Haupteingang"
        ),
    )
}
