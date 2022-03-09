package fr.zunkit.rfid_presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun Rfid(
    viewModel: RfidViewModel
) {
    val state by viewModel.uiState.collectAsState()
    Rfid(
        viewState = state,
        events = viewModel::handleAuthenticationEvent
    )
}

@Composable
private fun Rfid(
    viewState: RfidState,
    events: (event: RfidEvent) -> Unit
) {
    Text(text = "Hello RFID !")
}
