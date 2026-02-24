package org.openmind.mentalhealth.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

import org.openmind.mentalhealth.domain.model.JournalEntry
import org.openmind.mentalhealth.domain.model.Mood
import org.openmind.mentalhealth.domain.repository.JournalRepository
import org.openmind.mentalhealth.domain.usecase.SaveJournalEntryUseCase
import org.openmind.mentalhealth.ml.EmotionAnalyzer

class SaveJournalEntryUseCaseTest {

    private class FakeRepository : JournalRepository {
        var savedEntry: JournalEntry? = null

        override suspend fun save(entry: JournalEntry) {
            savedEntry = entry
        }
    }

    private class FakeAnalyzer : EmotionAnalyzer {
        override suspend fun analyze(text: String): Mood {
            return Mood.HAPPY
        }
    }

    @Test
    fun savesEntryWithAnalyzedMood() = runTest {
        val repository = FakeRepository()
        val analyzer = FakeAnalyzer()

        val useCase = SaveJournalEntryUseCase(repository, analyzer)

        useCase("Test entry")

        assertEquals(Mood.HAPPY, repository.savedEntry?.mood)
        assertEquals("Test entry", repository.savedEntry?.text)
    }
}
