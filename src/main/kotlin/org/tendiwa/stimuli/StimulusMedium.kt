package org.tendiwa.stimuli

import org.tendiwa.existence.Aspect
import java.util.*

/**
 * An environment through which [stimuli][Stimulus] reach [aspects][Aspect].
 */
class StimulusMedium {
    private val subscriptions
        : MutableMap<Class<out Stimulus>, MutableCollection<Aspect>> =
        LinkedHashMap()

    private val providerOfSets = { LinkedHashSet<Aspect>() }
    private val omnisubscribers: MutableList<(Stimulus) -> Unit> = ArrayList()

    fun subscribe(subscriber: Aspect, kind: Class<out Stimulus>) {
        subscriptions
            .getOrPut(kind, providerOfSets)
            .add(subscriber)
    }

    fun subscribeToAll(omnisubcriber: (Stimulus) -> Unit) {
        omnisubscribers.add(omnisubcriber)
    }

    fun sendStimulus(stimulus: Stimulus) {
        omnisubscribers
            .forEach { it(stimulus) }
        subscriptions
            .getOrPut(stimulus.javaClass, providerOfSets)
            .forEach { it.reaction(this, stimulus) }
    }
}

