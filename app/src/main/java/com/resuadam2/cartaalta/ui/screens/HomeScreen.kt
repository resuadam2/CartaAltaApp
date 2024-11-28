package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun HomeScreen(
    onPlay: () -> Unit
) {
    Column {
        Text("Bienvenido al juego de Carta Alta")
        Text("Pulsa en 'Jugar' para comenzar")
        Button(
            onClick = {
                onPlay()
            },
            content = { Text("Jugar") }
        )
    }
}