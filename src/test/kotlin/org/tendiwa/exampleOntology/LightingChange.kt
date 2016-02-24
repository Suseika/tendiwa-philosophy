package org.tendiwa.exampleOntology

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusKind

class LightingChange(
    val old: Double,
    val new: Double
) : Stimulus(kind) {
    companion object {
        val kind = StimulusKind("lighting change")
    }
}
