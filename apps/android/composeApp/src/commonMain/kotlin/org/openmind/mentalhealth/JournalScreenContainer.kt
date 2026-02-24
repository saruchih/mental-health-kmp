package org.openmind.mentalhealth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.MainScope

import org.openmind.mentalhealth.core.AppContainer
import org.openmind.mentalhealth.presentation.journal.JournalStore
import org.openmind.mentalhealth.presentation.journal.JournalViewModel

@Composable
fun JournalScreenContainer(
    appContainer: AppContainer,

    ) {
    val store = remember { JournalStore() }
    val scope = rememberCoroutineScope()


    val viewModel = remember {
        JournalViewModel(
            saveJournalEntry = appContainer.saveJournalEntryUseCase,
            store = store,
            scope = scope// platform scope (OK for now)
        )
    }

    val state = viewModel.state.collectAsState()

    JournalScreen(
        state = state.value,
        onIntent = viewModel::onIntent
    )
}
