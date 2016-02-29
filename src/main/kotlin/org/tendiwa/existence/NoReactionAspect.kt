package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusMedium

abstract class NoReactionAspect(kind: AspectKind) : Aspect(kind) {
    override fun reaction(medium: StimulusMedium, stimulus: Stimulus) {

    }
}
