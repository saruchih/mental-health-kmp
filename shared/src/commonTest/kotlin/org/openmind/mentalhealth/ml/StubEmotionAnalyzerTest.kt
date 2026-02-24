package org.openmind.mentalhealth.ml

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.openmind.mentalhealth.domain.model.Mood

class StubEmotionAnalyzerTest {

    private val analyzer = StubEmotionAnalyzer()

    @Test
    fun returnsHappyWhenTextContainsHappy() = runTest {
        val mood = analyzer.analyze("I am very happy today")
        assertEquals(Mood.HAPPY, mood)
    }

    @Test
    fun returnsNeutralWhenNoKeyword() = runTest {
        val mood = analyzer.analyze("Just writing something random")
        assertEquals(Mood.NEUTRAL, mood)
    }
}
