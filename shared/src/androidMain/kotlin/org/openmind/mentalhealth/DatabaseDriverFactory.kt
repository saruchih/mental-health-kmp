package org.openmind.mentalhealth

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.openmind.mentalhealth.database.JournalDatabase

class DatabaseDriverFactory(private val context: Context) {
    fun createDriver() =
        AndroidSqliteDriver(JournalDatabase.Schema, context, "journal.db")
}
