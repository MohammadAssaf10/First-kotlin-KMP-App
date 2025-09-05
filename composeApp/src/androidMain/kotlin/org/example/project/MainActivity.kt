package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            var textFieldsState: String by remember {
                mutableStateOf("")
            }
            val snackBarHostState: SnackbarHostState = remember { SnackbarHostState() }
            val coroutineScope: CoroutineScope = rememberCoroutineScope()
            val focusManager: FocusManager = LocalFocusManager.current
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                    ) {
                        focusManager.clearFocus()
                    },
                snackbarHost = { SnackbarHost(snackBarHostState) },
                topBar = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(Color.Blue)
                    )
                },
                content = { contentPadding: PaddingValues ->
                    Column(
                        modifier = Modifier
                            .padding(contentPadding)
                            .padding(
                                top = 40.dp,
                                start = 30.dp,
                                end = 30.dp
                            )
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextField(
                            value = textFieldsState,
                            label = {
                                Text(text = "Label")
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { value: String ->
                                println(value)
                                textFieldsState = value
                            },
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                focusManager.clearFocus()
                                coroutineScope.launch {
                                    snackBarHostState.showSnackbar("Hello $textFieldsState")
                                }
                            }
                        ) {
                            Text("Pls greet me")
                        }

                    }
                }
            )


        }
    }
}