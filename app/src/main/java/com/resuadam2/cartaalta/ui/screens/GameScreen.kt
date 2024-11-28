package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.resuadam2.cartaalta.ui.state.GameScreenViewModel

@Composable
fun GameScreen (
    onGameOver: (String) -> Unit,
) {
    GameScreenContent(
        onGameOver = onGameOver,
    )
}

@Composable
fun GameScreenContent(
    onGameOver: (String) -> Unit,
    gameScreenVM: GameScreenViewModel = viewModel()
) {
    val state by gameScreenVM.state.collectAsState()
    Column {
        PlayerCard(
            playerName = "Jugador 1",
            haTirado = state.jugador1HaTirado,
            carta = state.jugador1Carta.toString(),
            onTirar = { gameScreenVM.jugador1Tira() },
        )
        PlayerCard(
            playerName = "Jugador 2",
            haTirado = state.jugador2HaTirado,
            carta = state.jugador2Carta.toString(),
            onTirar = { gameScreenVM.jugador2Tira() }
        )
        Button(
            onClick = { onGameOver(state.ganador.toString()) },
            enabled = gameScreenVM.todosHanTirado(),
            content = { Text("Terminar partida") }
        )
    }

}

@Composable
fun PlayerCard(
    playerName: String,
    haTirado: Boolean = false,
    carta: String = "",
    onTirar: () -> Unit
    ) {
    Row {
        Button(
            onClick = onTirar,
            enabled = !haTirado,
            content = { Text("Area de juego de $playerName") }
        )
        Text(
            text = carta,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
