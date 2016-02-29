package org.tendiwa.time

import org.junit.Test
import org.mockito.Mockito.*
import java.util.*
import kotlin.test.assertEquals

class TimeStreamTest {
    @Test
    fun `new actor acts when added`() {
        val context = 1
        val actor : Actor<Int> = (mock(Actor::class.java) as Actor<Int>)
            .apply {
                `when`(act(context))
                    .then { Activity(listOf(Cooldown(1))) }
            }
        TimeStream(context, listOf())
            .apply { addActor(actor) }
        verify(actor, times(1)).act(context)
    }

    @Test
    fun play() {
        val context = 1
        var resultCalled = false
        val actor = (mock(Actor::class.java) as Actor<Int>)
            .apply {
                `when`(act(context))
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
        TimeStream(context, listOf(actor))
            .apply { play() }
        assert(resultCalled)
    }

    @Test
    fun `activity registered earlier produces result earlier if multiple activities end at the same moment`() {
        val context = 1
        val animals = ArrayList<String>()
        val catActor = object : Actor<Int> {
            override fun act(context: Int): Activity {
                return Activity(
                    listOf(
                        ActivityProcess(2, ActivityResult {
                            animals.add("cat")
                        })
                    )
                )
            }
        }
        val dogActor = object : Actor<Int> {
            override fun act(context: Int): Activity {
                return Activity(
                    listOf(
                        ActivityProcess(2, ActivityResult {
                            animals.add("dog")
                        })
                    )
                )
            }
        }
        TimeStream(context, listOf())
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
