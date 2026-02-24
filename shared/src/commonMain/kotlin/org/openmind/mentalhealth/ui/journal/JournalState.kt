package org.openmind.mentalhealth.ui.journal

import org.openmind.mentalhealth.domain.model.Mood

/**
 * ✔ Single source of truth
 * ✔ Immutable
 * ✔ Easy to test
 */
data class JournalState(
    val text: String = "",
    val mood: Mood? = null,
    val isSaving: Boolean = false,
    val error: String? = null
)