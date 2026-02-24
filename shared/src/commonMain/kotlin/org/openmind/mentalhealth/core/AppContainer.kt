package org.openmind.mentalhealth.core

import org.openmind.mentalhealth.data.local.InMemoryJournalRepository
import org.openmind.mentalhealth.domain.repository.JournalRepository
import org.openmind.mentalhealth.domain.usecase.SaveJournalEntryUseCase
import org.openmind.mentalhealth.ml.StubEmotionAnalyzer
import org.openmind.mentalhealth.presentation.journal.JournalStore
import org.openmind.mentalhealth.presentation.journal.JournalViewModel

/**
 * Simple manual dependency container.
 * Replaces DI frameworks for now.
 */
class AppContainer(  journalRepository: JournalRepository) {

    // Data layer

    // ML layer
    private val emotionAnalyzer = StubEmotionAnalyzer()

    // Use cases
    val saveJournalEntryUseCase: SaveJournalEntryUseCase =
        SaveJournalEntryUseCase(
            repository = journalRepository,
            emotionAnalyzer = emotionAnalyzer
        )

//    val journalStore = JournalStore()
//
//    val journalViewModel = JournalViewModel(
//        saveJournalEntry = saveJournalEntryUseCase,
//        store = journalStore,
//        scope = appScope
//    )
}