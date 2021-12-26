package com.luc.manager.ui.views.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun CircularIndeterminateProgressBar(isDisplayed: Boolean) {
    if (isDisplayed) {
        CircularProgressIndicator(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun TextField(modifier: Modifier, label: String, onTextChange: (String) -> Unit) {
    var value by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onTextChange(it)
            value = it
        },
        label = { Text(label) }
    )
}

@Composable
fun Snackbar(text: String) {
    if (text.isEmpty()) return

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(Modifier.size(600.dp)) {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(message = text)
        }

        SnackbarHost(
            hostState = snackbarHostState,
        )
    }
}