package org.tendiwa.stimuli

import org.junit.Test
import org.tendiwa.exampleOntology.LightingChange
import org.tendiwa.exampleOntology.Sanity

class StimulusMediumTest {
    @Test
    fun passesStimuli() {
        val sanity = Sanity()
        val oldSanityValue = sanity.amount
        StimulusMedium().apply {
            subscribe(sanity, LightingChange.KIND)
            sendStimulus(LightingChange(1.0, 2.0))
        }
        assert(oldSanityValue != sanity.amount)
    }
}
