package org.tendiwa.exampleOntology

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusKind

class LightingChange(
    val old: Double,
    val new: Double
) : Stimulus(KIND) {
    companion object {
        val KIND = StimulusKind("lighting change")
    }
}
