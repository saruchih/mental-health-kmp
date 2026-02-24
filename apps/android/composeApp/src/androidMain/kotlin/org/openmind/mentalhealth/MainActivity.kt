package org.openmind.mentalhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import org.openmind.mentalhealth.di.createAppContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val context = this
            val appContainer = remember {
                createAppContainer(context)
            }

            App(appContainer)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    val appContainer = remember {
//        createAppContainer(this)
//    }
//    App(appContainer)
}