package com.luc.manager.ui.views.panel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationsPanel() {
    Surface(color = MaterialTheme.colors.primaryVariant) {
        Column(modifier = Modifier.width(60.dp).fillMaxHeight(), horizontalAlignment = Alignment.End) {
            ApplicationsButton()
        }
    }
}

@Composable
fun ApplicationsButton() {
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 50.dp, topStart = 50.dp))
    ) {
        Box(modifier = Modifier
            .size(50.dp, 50.dp)
            .clickable { }
        ) {
            Icon(
                Icons.Filled.Lock,
                "contentDescription",
                modifier = Modifier.align(Alignment.Center)
            )

        }
    }
}
