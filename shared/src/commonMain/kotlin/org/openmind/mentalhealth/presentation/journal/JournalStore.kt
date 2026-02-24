package org.openmind.mentalhealth.presentation.journal

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import org.openmind.mentalhealth.ui.journal.JournalEffect
import org.openmind.mentalhealth.ui.journal.JournalState

class JournalStore {

    private val _state = MutableStateFlow(JournalState())
    val state: StateFlow<JournalState> = _state

    private val _effects = MutableSharedFlow<JournalEffect>()
    val effects = _effects.asSharedFlow()

    fun reduce(result: JournalResult) {
        _state.update { current ->
            when (result) {
                is JournalResult.TextUpdated ->
                    current.copy(text = result.text, error = null)

                JournalResult.Saving ->
                    current.copy(isSaving = true, error = null)

                is JournalResult.Saved ->
                    current.copy(
                        isSaving = false,
                        mood = result.mood,
                        text = ""
                    )

                is JournalResult.Error ->
                    current.copy(
                        isSaving = false,
                        error = result.message
                    )
            }
        }
    }

    suspend fun emitEffect(effect: JournalEffect) {
        _effects.emit(effect)
    }
}