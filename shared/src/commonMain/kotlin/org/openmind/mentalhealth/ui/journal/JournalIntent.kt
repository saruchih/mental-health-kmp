package org.openmind.mentalhealth.ui.journal

/**
 * Represents user actions only
 */
sealed interface JournalIntent {

    data class TextChanged(val text: String) : JournalIntent

    object SaveClicked : JournalIntent
}