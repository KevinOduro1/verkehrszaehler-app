package de.thkoeln.vma.trafficcounter.viewmodel

import de.thkoeln.vma.trafficcounter.TrafficApplication
import kotlin.reflect.KProperty

private operator fun Any.getValue(
    trafficApplication: TrafficApplication,
    property: KProperty<*>
): Any {
    TODO("Not yet implemented")
}
