package org.tendiwa.time

import org.tendiwa.existence.RealThing

abstract class Actor : RealThing() {
    abstract fun act(): Activity
}
