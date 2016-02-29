package org.tendiwa.time

interface Actor<Context> {
    fun act(context: Context): Activity
}
