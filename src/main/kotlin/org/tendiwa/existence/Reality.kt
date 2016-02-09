package org.tendiwa.existence

import java.util.*

class Reality {
    val things: MutableMap<RealThing, Collection<Aspect>> =
        HashMap()

//    val observation: MutableMap<RealThing, Collection<RealThing>>

    /**
     * Make a real thing not exist in this [Reality].
     */
    fun obliterate(thing: RealThing) {
//        things[thing]!!.forEach {
//
//        }
        things.remove(thing)
    }
}

