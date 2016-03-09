package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusMedium

interface Aspect {
    fun reaction(medium: StimulusMedium, stimulus: Stimulus)

    fun init(host: RealThing)

    val stimuli: List<Stimulus>
}
