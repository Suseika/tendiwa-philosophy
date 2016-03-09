package org.tendiwa.existence

import java.util.*

/**
 * An interactive thing in simulation characterized by a number of its
 * [Aspects][Aspect];
 *
 * Aspects and archetypes completely define what the thing is and what it does.
 */
abstract class RealThing(
    aspects: List<Aspect> = emptyList()
) {
    private val _aspects: MutableMap<Class<out Aspect>, Aspect> =
        LinkedHashMap<Class<out Aspect>, Aspect>()
            .apply {
                for (aspect in aspects) {
                    put(aspect.javaClass, aspect)
                }
            }

    val aspects: Map<Class<out Aspect>, Aspect> get() = _aspects

    fun addAspect(aspect: Aspect) {
        _aspects[aspect.javaClass] = aspect
        aspect.init(this)
    }

    fun removeAspect(kind: Class<Aspect>) {
        _aspects.remove(kind)
    }

    fun hasAspect(aspectKind: Class<Aspect>): Boolean =
        aspects.containsKey(aspectKind)
}
