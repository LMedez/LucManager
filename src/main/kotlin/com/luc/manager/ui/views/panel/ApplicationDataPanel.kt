package com.luc.manager.ui.views.panel

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationDataPanel() {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.background) {
            Text("RHCP fan art application", modifier = Modifier.padding(start = 16.dp))
        }
    }, backgroundColor = MaterialTheme.colors.surface) {
        RhcpAppPanel()
    }

}





