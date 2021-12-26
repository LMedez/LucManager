package com.luc.manager.ui.views.panel

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun ApplicationFunctionalityPanel() {
    Surface(color = MaterialTheme.colors.secondary) {
        Column(modifier = Modifier.fillMaxWidth(0.2F).fillMaxHeight()) {
            Button(onClick = {}, Modifier.fillMaxWidth()) { Text("BUTTON TEXT") }
        }
    }
}



