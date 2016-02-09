package org.tendiwa.exampleOntology

import org.tendiwa.existence.Aspect
import org.tendiwa.existence.AspectKind
import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusKind
import org.tendiwa.stimuli.StimulusMedium

class Sanity() : Aspect(type) {

    companion object {
        private val type = AspectKind()
    }

    var amount: Double = 1.0
        private set

    fun change(medium: StimulusMedium, amount: Double) {
        val old = this.amount
        this.amount += amount
        medium.sendStimulus(Change(old, amount))
    }

    override fun reaction(medium: StimulusMedium, stimulus: Stimulus) {
        when (stimulus) {
            is LightingChange -> change(
                medium,
                stimulus.new * 1.0
            )
        }
    }

    class Change(val old: Double, val new: Double) : Stimulus(kind) {
        companion object {
            val kind = StimulusKind("sanity change")
        }
    }
}
