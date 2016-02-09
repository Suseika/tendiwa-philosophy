package org.tendiwa.time

import java.util.*

class TimeStream(actors: List<Actor>) {
    private val actorsToCurrentActivities = LinkedHashMap<Actor, Activity>()

    fun play() {

    }

    fun interruptActivity(actor: Actor) {
        actorsToCurrentActivities[actor]
    }
}
