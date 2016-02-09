package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusMedium

abstract class Aspect(
    val kind: AspectKind
) : RealThing() {
    abstract fun reaction(medium: StimulusMedium, stimulus: Stimulus)
}
