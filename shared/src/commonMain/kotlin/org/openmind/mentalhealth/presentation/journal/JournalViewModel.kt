package org.openmind.mentalhealth.presentation.journal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.openmind.mentalhealth.domain.usecase.SaveJournalEntryUseCase
import org.openmind.mentalhealth.ui.journal.JournalEffect
import org.openmind.mentalhealth.ui.journal.JournalIntent

class JournalViewModel(
    private val saveJournalEntry: SaveJournalEntryUseCase,
    private val store: JournalStore,
    private val scope: CoroutineScope
) {

    val state = store.state
    val effects = store.effects

    fun onIntent(intent: JournalIntent) {
        when (intent) {
            is JournalIntent.TextChanged ->
                store.reduce(JournalResult.TextUpdated(intent.text))

            JournalIntent.SaveClicked ->
                save()
        }
    }

    private fun save() {
        scope.launch {
            store.reduce(JournalResult.Saving)

            runCatching {
                saveJournalEntry(store.state.value.text)
            }.onSuccess {
                store.reduce(
                    JournalResult.Saved(
                        mood = store.state.value.mood ?: return@onSuccess
                    )
                )
                store.emitEffect(JournalEffect.NavigateBack)
            }.onFailure {
                store.reduce(
                    JournalResult.Error(it.message ?: "Something went wrong")
                )
                store.emitEffect(
                    JournalEffect.ShowError("Failed to save journal")
                )
            }
        }
    }
}
