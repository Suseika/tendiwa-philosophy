package org.tendiwa.exampleOntology

import org.tendiwa.existence.NoInitAspect
import org.tendiwa.existence.NoStimuliAspect
import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusMedium

class Sanity() : NoStimuliAspect, NoInitAspect {

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

    class Change(val old: Double, val new: Double) : Stimulus
}
