package com.luc.manager// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.luc.data.di.dataModule
import com.luc.domain.di.domainModule
import com.luc.manager.ui.theme.LightTheme
import com.luc.manager.ui.views.panel.ApplicationFunctionalityPanel
import com.luc.manager.ui.views.panel.ApplicationDataPanel
import com.luc.manager.ui.views.panel.ApplicationsPanel
import com.luc.presentation.di.presentationModule
import org.koin.core.context.startKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = WindowSize(1840.dp, 1000.dp)
        ), title = "Luc Manager"
    ) {
        App()
    }

    startKoin {
        modules(dataModule + domainModule + presentationModule)
    }
}

@Composable
@Preview
fun App() {
    LightTheme {
        Row {
            ApplicationsPanel()
            ApplicationFunctionalityPanel()
            ApplicationDataPanel()
        }
    }
}





