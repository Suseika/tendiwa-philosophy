package org.tendiwa.time

import java.util.*

/**
 * Maintains the chronological order of concurrent actions of multiple
 * [Actors][Actor].
 */
class TimeStream<Context>(
    private val context: Context,
    actors: List<Actor<Context>>
) {
    private val actorsToTodoqueues: MutableMap<Actor<Context>, Todoqueue> =
        LinkedHashMap()

    init {
        actors.forEach {
            scheduleNextActionOf(it)
        }
    }

    fun addActor(actor: Actor<Context>) {
        if (actorsToTodoqueues.containsKey(actor)) {
            throw IllegalArgumentException(
                "Actor $actor is already in this TimeStream"
            )
        }
        scheduleNextActionOf(actor)
    }

    /**
     * Pass time until the soonest end of an [ActivityProcess] in one of started
     * [Activities][Activity].
     */
    fun play() {
        val nextEntry =
            actorsToTodoqueues
                .entries
                .minBy { it.value.timeToEndOfCurrentProcess() }!!
        val nextTodoqueue =
            nextEntry.value
        val timePassed =
            nextTodoqueue.timeToEndOfCurrentProcess()
        actorsToTodoqueues
            .values
            .forEach { it.passTime(timePassed) }
        nextTodoqueue.doCurrentProcess()
        if (nextTodoqueue.isDone()) {
            scheduleNextActionOf(nextEntry.key)
        }
    }

    /**
     * Replaces the current activity of [actor] with a new activity chosen
     * with [Actor.act].
     */
    fun interruptActivity(actor: Actor<Context>) {
        if (actorsToTodoqueues.containsKey(actor)) {
            throw IllegalArgumentException(
                "Actor $actor doesn't have any current activity in this TimeStream"
            )
        }
        scheduleNextActionOf(actor)
    }

    /**
     * Puts the next [Activity] of an [Actor] to the schedule at current moment.
     */
    private fun scheduleNextActionOf(actor: Actor<Context>) {
        actorsToTodoqueues.put(
            actor,
            Todoqueue(actor.act(context).processes)
        )
    }
}
