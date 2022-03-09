package fr.zunkit.authentication

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun Authentication(
    viewModel: AuthenticationViewModel
) {
    val state by viewModel.uiState.collectAsState()
    Authentication(
        viewState = state,
        events = viewModel::handleAuthenticationEvent
    )
}

@Composable
private fun Authentication(
    viewState: AuthenticationState,
    events: (event: AuthenticationEvent) -> Unit
) {
    Text(text = "Hello !")
}
