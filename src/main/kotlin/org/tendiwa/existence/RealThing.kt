package org.tendiwa.existence

import java.util.*

abstract class RealThing {
    private val _aspects: MutableMap<AspectKind, Aspect> = LinkedHashMap()

    val aspects: Map<AspectKind, Aspect> get() = _aspects

    fun addAspect(aspect: Aspect) {
        _aspects[aspect.kind] = aspect
    }

    fun removeAspect(kind: AspectKind) {
        _aspects.remove(kind)
    }
}
