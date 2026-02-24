package org.openmind.mentalhealth.di

import android.content.Context
import org.openmind.mentalhealth.DatabaseDriverFactory
import org.openmind.mentalhealth.core.AppContainer
import org.openmind.mentalhealth.data.local.SQLDelightJournalRepository
import org.openmind.mentalhealth.database.JournalDatabase

fun createAppContainer(context: Context): AppContainer {

    val driver = DatabaseDriverFactory(context).createDriver()
    val database = JournalDatabase(driver)
    val repository = SQLDelightJournalRepository(database)

    return AppContainer(repository)
}
