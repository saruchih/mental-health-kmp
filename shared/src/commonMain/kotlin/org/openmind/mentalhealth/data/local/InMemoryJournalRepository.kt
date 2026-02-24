package org.openmind.mentalhealth.data.local

import org.openmind.mentalhealth.domain.model.JournalEntry
import org.openmind.mentalhealth.domain.repository.JournalRepository

/**
 * Temporary local repository.
 * Offline-first, multiplatform-safe.
 *
 * Will be replaced later with SQLDelight.
 */
class InMemoryJournalRepository : JournalRepository {

    private val entries = mutableListOf<JournalEntry>()

    override suspend fun save(entry: JournalEntry) {
        entries.add(entry)
    }

    // Optional helper (not in domain)
    fun getAll(): List<JournalEntry> = entries.toList()
}