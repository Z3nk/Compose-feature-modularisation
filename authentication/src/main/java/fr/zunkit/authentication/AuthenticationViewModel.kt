package fr.zunkit.authentication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.zunkit.navigation.AuthenticationDirections
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
        if (event is AuthenticationEvent.AuthenticateClicked) {
            _uiState.value = uiState.value.build {
                loading = true
            }
            navigationManager.navigate(AuthenticationDirections.Success)
        } else {
            _uiState.value = uiState.value.build {
                when (event) {
                    AuthenticationEvent.DismissErrorDialog -> {
                        this.error = null
                    }
                    AuthenticationEvent.AuthenticateClicked -> {
                        this.loading = true
                    }
                    AuthenticationEvent.ForgotPasswordClicked -> {
//                        navigationManager.navigate(
//                            AuthenticationDirections.forgotPassword
//                        )
                    }
                    is AuthenticationEvent.EmailChanged -> {
                        this.userEmail = event.email
                    }
                    is AuthenticationEvent.PasswordChanged -> {
                        this.userPassword = event.password
                    }
                }
            }
        }
    }

}