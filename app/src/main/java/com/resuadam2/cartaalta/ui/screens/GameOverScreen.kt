package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun GameOverScreen(
    ganador: String,
    onRestart: () -> Unit
) {
    Column {
        Text("El ganador es $ganador")
        Button(
            onClick = {
                onRestart()
            },
            content = { Text("Reiniciar") }
        )
    }
}