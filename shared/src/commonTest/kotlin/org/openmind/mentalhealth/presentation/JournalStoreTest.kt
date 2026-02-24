package org.openmind.mentalhealth.presentation

import org.openmind.mentalhealth.presentation.journal.JournalResult
import org.openmind.mentalhealth.presentation.journal.JournalStore
import kotlin.test.Test
import kotlin.test.assertEquals
import org.openmind.mentalhealth.ui.journal.JournalState

class JournalStoreTest {

    @Test
    fun textUpdatedChangesStateText() {
        val store = JournalStore()

        store.reduce(JournalResult.TextUpdated("Hello"))

        val state = store.state.value
        assertEquals("Hello", state.text)
    }

    @Test
    fun savingSetsLoadingTrue() {
        val store = JournalStore()

        store.reduce(JournalResult.Saving)

        val state = store.state.value
        assertEquals(true, state.isSaving)
    }
}
