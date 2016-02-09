package org.tendiwa.time

data class Activity(
    val processes: List<ActivityProcess>,
    val cooldown: Double
) {

}
