package org.tendiwa.exampleOntology

import org.tendiwa.time.Activity
import org.tendiwa.time.ActivityProcess
import org.tendiwa.time.ActivityResult
import org.tendiwa.time.Actor

class Dog : Actor() {
    override fun act(): Activity =
        Activity(
            listOf(
                ActivityProcess(
                    1.0,
                    ActivityResult { println("Dog barks") }
                )
            ),
            cooldown = 0.5
        )
}
