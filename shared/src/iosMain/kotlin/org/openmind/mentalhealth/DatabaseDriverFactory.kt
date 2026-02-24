package org.openmind.mentalhealth

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.openmind.mentalhealth.database.JournalDatabase

class DatabaseDriverFactory {
    fun createDriver() =
        NativeSqliteDriver(JournalDatabase.Schema, "journal.db")
}
