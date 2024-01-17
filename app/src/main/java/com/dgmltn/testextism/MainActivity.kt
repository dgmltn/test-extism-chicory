package com.dgmltn.testextism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dgmltn.testextism.ui.theme.TestExtismTheme

class MainActivity : ComponentActivity() {

    val chicoryRunner by lazy { ChicoryRunner(resources) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var output by remember { mutableStateOf("waiting...") }

            TestExtismTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Button(onClick = {
                        output = chicoryRunner.go()
                    }) {
                        Text("Go!")
                    }
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = output
                    )
                }
            }
        }
    }
}
