package org.tendiwa.existence

import org.tendiwa.stimuli.Stimulus

class AspectKind(val stimuli: List<Class<Stimulus>>)

fun NoStimuliAspectKind() = AspectKind(emptyList())
