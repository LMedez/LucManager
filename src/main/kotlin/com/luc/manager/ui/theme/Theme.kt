package com.luc.manager.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors(
    primary = orange400,
    secondary = darkBlue700,
    surface = darkBlue100,
    secondaryVariant = darkBlue400,
    primaryVariant = lightBlue300
)

@Composable
fun LightTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        content = content
    )
}