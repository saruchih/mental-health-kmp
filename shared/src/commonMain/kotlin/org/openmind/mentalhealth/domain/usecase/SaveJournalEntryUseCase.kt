package org.openmind.mentalhealth.domain.usecase

import org.openmind.mentalhealth.domain.ml.EmotionAnalyzer
import org.openmind.mentalhealth.domain.model.JournalEntry
import org.openmind.mentalhealth.domain.repository.JournalRepository
import kotlin.time.Clock


class SaveJournalEntryUseCase(
    private val repository: JournalRepository,
    private val emotionAnalyzer: EmotionAnalyzer
) {
    suspend operator fun invoke(text: String) {
        val mood = emotionAnalyzer.analyze(text)
        repository.save(
            JournalEntry(
                text = text,
                mood = mood,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}