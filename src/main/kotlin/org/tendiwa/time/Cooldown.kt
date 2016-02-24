package org.tendiwa.time

/**
 * Activity process at the end of which happens nothing.
 */
fun Cooldown(duration: Int): ActivityProcess =
    ActivityProcess(duration, ActivityResult { })
