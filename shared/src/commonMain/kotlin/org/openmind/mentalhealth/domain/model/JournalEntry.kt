package org.openmind.mentalhealth.domain.model

data class JournalEntry(
    val text: String,
    val mood: Mood,
    val timestamp: Long
)