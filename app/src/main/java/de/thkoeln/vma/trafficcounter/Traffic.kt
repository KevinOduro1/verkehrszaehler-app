package de.thkoeln.vma.trafficcounter

import java.time.LocalDateTime


data class Traffic (
    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
){

    // Möglicherweise braucht der eine oder andere Entwickler später hier auch noch ALL
    enum class TrafficType {
        CYCLING, FOOT
    }
}

