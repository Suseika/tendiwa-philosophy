package org.tendiwa.existence

import java.util.*

abstract class RealThing {
    private val aspects: MutableMap<AspectKind, Aspect> = LinkedHashMap()

    fun addAspect(aspect: Aspect) {
        aspects[aspect.kind] = aspect
    }

    fun removeAspect(kind: AspectKind) {
        aspects.remove(kind)
    }
}
