package fr.zunkit.rfid_presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun Rfid(
    viewModel: RfidViewModel,
    name: String
) {
    val state by viewModel.uiState.collectAsState()
    Rfid(
        viewState = state,
        events = viewModel::handleRfidDeviceEvent,
        name = name
    )
}

@Composable
private fun Rfid(
    viewState: RfidState,
    events: (event: RfidEvent) -> Unit,
    name: String
) {
    Text(text = "Hello RFID $name !")
}
