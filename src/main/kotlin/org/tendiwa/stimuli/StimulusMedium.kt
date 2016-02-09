package org.tendiwa.stimuli

import org.tendiwa.existence.Aspect
import java.util.*

/**
 * An environment through which [stimuli][Stimulus] reach [aspects][Aspect].
 */
class StimulusMedium {
    private val subscriptions
        : MutableMap<StimulusKind, MutableCollection<Aspect>> =
        LinkedHashMap()

    private val providerOfSets = { LinkedHashSet<Aspect>() }

    fun subscribe(subscriber: Aspect, stimulusKind: StimulusKind) {
        subscriptions
            .getOrPut(stimulusKind, providerOfSets)
            .add(subscriber)
    }

    fun sendStimulus(stimulus: Stimulus) {
        subscriptions
            .getOrPut(stimulus.kind, providerOfSets)
            .forEach { it.reaction(this, stimulus) }
    }
}

