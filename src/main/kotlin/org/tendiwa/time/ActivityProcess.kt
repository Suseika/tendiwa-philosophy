package org.tendiwa.time

/**
 * @param duration Duration of the process in time quantums.
 * @param result What happens when the process finishes, i.e. when time equal
 * to [duration] passes since the beginning of the process.
 */
data class ActivityProcess(
    val duration: Int,
    val result: ActivityResult
)
