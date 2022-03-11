package fr.zunkit.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = viewState.emailAddress,
            label = { Text(stringResource(id = R.string.label_email)) },
            onValueChange = { viewState.emailAddress = it },
        )
        Button(onClick = {
            events(AuthenticationEvent.AuthenticateClicked)
        }) {
            Text("Login")
        }
    }

}


@Preview(widthDp = 420)
@Composable
fun EmailInputField2Preview() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Authentication(AuthenticationState()) {}
    }
}
