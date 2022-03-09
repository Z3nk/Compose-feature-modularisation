package fr.zunkit.rfid_presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RfidViewModel @Inject constructor() :
    ViewModel() {
    private val _uiState = MutableStateFlow(RfidState())
    val uiState: StateFlow<RfidState> = _uiState

    fun handleAuthenticationEvent(event: RfidEvent) {
        if (event is RfidEvent.Connected) {
            _uiState.value = uiState.value.build {
                name = "connected"
            }
//            connected()
        }
    }
}