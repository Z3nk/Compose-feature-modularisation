package fr.zunkit.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


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
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            events(AuthenticationEvent.AuthenticateClicked)
        }){
            Text("Login")
        }
    }
}
