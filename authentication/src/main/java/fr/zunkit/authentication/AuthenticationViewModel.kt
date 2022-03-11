package fr.zunkit.authentication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.zunkit.navigation.NavigationEvent
import fr.zunkit.navigation.NavigationManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val navigationManager: NavigationManager) :
    ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationState())
    val uiState: StateFlow<AuthenticationState> = _uiState

    fun handleAuthenticationEvent(event: AuthenticationEvent) {
        _uiState.value = uiState.value.build {
            when (event) {
                AuthenticationEvent.AuthenticateClicked -> {
                    _uiState.value = uiState.value.build {
                        loading = true
                    }
                    navigationManager.event(NavigationEvent.OnAuthentificated)
                }
            }
        }
    }

}