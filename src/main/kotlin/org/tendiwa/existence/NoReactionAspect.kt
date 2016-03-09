package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus
import org.tendiwa.stimuli.StimulusMedium

interface NoReactionAspect : Aspect {
    override fun reaction(medium: StimulusMedium, stimulus: Stimulus) {

    }
}
