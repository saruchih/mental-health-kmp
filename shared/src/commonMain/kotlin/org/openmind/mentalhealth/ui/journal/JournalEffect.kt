package org.openmind.mentalhealth.ui.journal

/**
 * ✔ One-time events only
 * ✔ Never stored in state
 */
sealed interface JournalEffect {

    object NavigateBack : JournalEffect

    data class ShowError(val message: String) : JournalEffect
}