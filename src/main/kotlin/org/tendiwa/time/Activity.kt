package org.tendiwa.time

/**
 * Chronological sequence of [ActivityProcess]es chronologically followed by a
 * [cooldown].
 */
data class Activity(
    val processes: List<ActivityProcess>
)
