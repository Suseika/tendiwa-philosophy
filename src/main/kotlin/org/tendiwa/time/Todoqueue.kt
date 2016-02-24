package org.tendiwa.time

import java.util.concurrent.ArrayBlockingQueue

/**
 * A planned ahead mutable sequence of [ActivityProcess]es where elements can
 * be removed from the beginning.
 */
internal class Todoqueue(processes: List<ActivityProcess>) {
    private var currentProcessDepth: Int = 0

    private val processes =
        ArrayBlockingQueue<ActivityProcess>(Math.max(processes.size, 1))
            .apply { addAll(processes) }

    /**
     * Returns how much time is there from the current moment to the end of
     * the process that is currently in progress.
     */
    fun timeToEndOfCurrentProcess(): Int =
        processes.peek().duration - currentProcessDepth

    fun passTime(amount: Int) {
        currentProcessDepth += amount
    }

    fun doCurrentProcess() {
        currentProcessDepth = 0
        val removed = processes.poll()
        removed.result.influence()
    }

    /**
     * Checks if there are any more [ActivityProcess] left.
     */
    fun isDone(): Boolean =
        processes.isEmpty()
}
