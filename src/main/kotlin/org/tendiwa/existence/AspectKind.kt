package org.tendiwa.existence

import org.tendiwa.stimuli.StimulusKind

data class AspectKind(val stimuli: List<StimulusKind>)

fun NoStimuliAspectKind() = AspectKind(emptyList())
