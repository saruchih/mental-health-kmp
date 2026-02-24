package org.openmind.mentalhealth.data.local

import org.openmind.mentalhealth.database.JournalDatabase
import org.openmind.mentalhealth.domain.model.JournalEntry
import org.openmind.mentalhealth.domain.repository.JournalRepository

class SQLDelightJournalRepository(
    private val database: JournalDatabase
) : JournalRepository {

    override suspend fun save(entry: JournalEntry) {
        database.journalQueries.insertJournal(
            text = entry.text,
            mood = entry.mood.name,
            timestamp = entry.timestamp
        )
    }
}
