package org.openmind.mentalhealth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.openmind.mentalhealth.ui.journal.JournalIntent
import org.openmind.mentalhealth.ui.journal.JournalState

@Composable
fun JournalScreen(
    state: JournalState,
    onIntent: (JournalIntent) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = state.text,
            onValueChange = {
                onIntent(JournalIntent.TextChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("How are you feeling?") }
        )

        Button(
            onClick = { onIntent(JournalIntent.SaveClicked) },
            enabled = !state.isSaving,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save")
        }

        state.error?.let {
            Text(
                text = it,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
