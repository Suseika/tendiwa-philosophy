package org.tendiwa.time

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class TodoqueueTest {
    @Test
    fun `passing time affects time to the end of current process`() {
        Todoqueue(
            listOf(Cooldown(3), Cooldown(3))
        )
            .apply {
                this.passTime(1)
                assertEquals(2, timeToEndOfCurrentProcess())
            }
    }

    @Test
    fun `time to end of current process after doing the current process is the duration of the next process`() {
        Todoqueue(
            listOf(Cooldown(3), Cooldown(10))
        )
            .apply {
                assertEquals(3, timeToEndOfCurrentProcess())
                doCurrentProcess()
                assertEquals(10, timeToEndOfCurrentProcess())
            }
    }

    @Test
    fun `having 0 processes means it is done`() {
        assert(Todoqueue(listOf()).isDone())
    }

    @Test
    fun `having more than 0 processes means it is not done`() {
        assertFalse(Todoqueue(listOf(Cooldown(1))).isDone())
    }

    @Test
    fun `can become done after removing processes`() {
        Todoqueue(
            listOf(Cooldown(1), Cooldown(2))
        )
            .apply {
                assertFalse(isDone())
                doCurrentProcess()
                doCurrentProcess()
                assert(isDone())
            }
    }
}
