package org.openmind.mentalhealth.presentation.journal

import org.openmind.mentalhealth.domain.model.Mood

sealed interface JournalResult {

    data class TextUpdated(val text: String) : JournalResult

    object Saving : JournalResult

    data class Saved(val mood: Mood) : JournalResult

    data class Error(val message: String) : JournalResult
}