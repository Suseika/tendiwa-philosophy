package org.tendiwa.exampleOntology

import org.tendiwa.time.*

class Worker(
    val name: String
) : Actor {
    override fun act(): Activity =
        Activity(
            listOf(
                ActivityProcess(
                    1,
                    ActivityResult {
                        println("$name says: 'I did half work'")
                    }
                ),
                ActivityProcess(
                    1,
                    ActivityResult {
                        println("$name says: 'I did whole work!'")
                    }
                ),
                Cooldown(1)
            )
        )
}
