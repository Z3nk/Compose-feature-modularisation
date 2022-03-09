package fr.zunkit.authentication

sealed class AuthenticationEvent {

    object DismissErrorDialog : AuthenticationEvent()
    object AuthenticateClicked : AuthenticationEvent()
    object ForgotPasswordClicked : AuthenticationEvent()
    data class EmailChanged(val email: String) : AuthenticationEvent()
    data class PasswordChanged(val password: String) : AuthenticationEvent()

}