package org.tendiwa.time

/**
 * Activity result is how a world is changed as a result of some [Activity].
 */
class ActivityResult(
    val influence: () -> Unit
)
