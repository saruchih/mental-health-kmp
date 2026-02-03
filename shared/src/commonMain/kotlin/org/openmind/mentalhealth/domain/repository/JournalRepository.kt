package org.openmind.mentalhealth.domain.repository

import org.openmind.mentalhealth.domain.model.JournalEntry

interface JournalRepository {
    suspend fun save(entry: JournalEntry)
}