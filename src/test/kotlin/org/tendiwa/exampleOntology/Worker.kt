package org.tendiwa.exampleOntology

import org.tendiwa.time.Activity
import org.tendiwa.time.ActivityProcess
import org.tendiwa.time.ActivityResult
import org.tendiwa.time.Actor

class Worker(
    val name: String
) : Actor() {
    override fun act(): Activity =
        Activity(
            listOf(
                ActivityProcess(
                    1.0,
                    ActivityResult {
                        println("$name says: 'I did half work'")
                    }
                ),
                ActivityProcess(
                    1.0,
                    ActivityResult {
                        println("$name says: 'I did whole work!'")
                    }
                )
            ),
            cooldown = 1.0
        )
}
