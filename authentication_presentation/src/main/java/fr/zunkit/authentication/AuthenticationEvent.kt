package fr.zunkit.authentication

sealed class AuthenticationEvent {
    object AuthenticateClicked : AuthenticationEvent()
}