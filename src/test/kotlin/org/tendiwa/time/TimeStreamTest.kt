package org.tendiwa.time

import org.junit.Test
import org.mockito.Mockito.*
import java.util.*
import kotlin.test.assertEquals

class TimeStreamTest {
    @Test
    fun `new actor acts when added`() {
        val actor = mock(Actor::class.java)
            .apply {
                `when`(act())
                    .then { Activity(listOf(Cooldown(1))) }
            }
        TimeStream(listOf())
            .apply { addActor(actor) }
        verify(actor, times(1)).act()
    }

    @Test
    fun play() {
        var resultCalled = false
        val actor = mock(Actor::class.java)
            .apply {
                `when`(act())
                    .then {
                        Activity(
                            listOf(
                                ActivityProcess(
                                    duration = 1,
                                    result = ActivityResult {
                                        resultCalled = true
                                    }
                                )
                            )
                        )
                    }
            }
        TimeStream(listOf(actor))
            .apply { play() }
        assert(resultCalled)
    }

    @Test
    fun `activity registered earlier produces result earlier if multiple activities end at the same moment`() {
        val animals = ArrayList<String>()
        val catActor = object : Actor {
            override fun act(): Activity {
                return Activity(
                    listOf(
                        ActivityProcess(2, ActivityResult {
                            animals.add("cat")
                        })
                    )
                )
            }
        }
        val dogActor = object : Actor {
            override fun act(): Activity {
                return Activity(
                    listOf(
                        ActivityProcess(2, ActivityResult {
                            animals.add("dog")
                        })
                    )
                )
            }
        }
        TimeStream(listOf())
            .apply {
                addActor(dogActor)
                addActor(catActor)
                play()
                play()
            }
        assertEquals(
            listOf("dog", "cat"),
            animals
        )
    }
}
