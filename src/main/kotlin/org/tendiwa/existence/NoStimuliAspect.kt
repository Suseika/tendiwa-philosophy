package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus

interface NoStimuliAspect : Aspect {
    override val stimuli: List<Class<Stimulus>>
        get() = emptyList()
}
