package org.tendiwa.exampleOntology

import org.tendiwa.time.*

class Dog : Actor {
    override fun act(): Activity =
        Activity(
            listOf(
                ActivityProcess(
                    2,
                    ActivityResult { println("Dog barks") }
                ),
                Cooldown(1)
            )
        )
}
