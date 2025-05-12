package de.thkoeln.vma.trafficcounter

import java.time.LocalDateTime

/**
 * SampleData for TrafficCounter
 */
object SampleData {
    val trafficSample = listOf(
        Traffic(
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 3),
            "Haupteingang"
        ),
        Traffic(
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 6),
            "Haupteingang"
        ),
        Traffic(
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 7),
            "Haupteingang"
        ),
        Traffic(
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 10),
            "Haupteingang"
        ),
        Traffic(
            Traffic.TrafficType.FOOT,
            LocalDateTime.of(2024, 11, 20, 12, 16),
            "Haupteingang"
        ),
        Traffic(
            Traffic.TrafficType.CYCLING,
            LocalDateTime.of(2024, 11, 20, 12, 18),
            "Haupteingang"
        ),
    )
}
