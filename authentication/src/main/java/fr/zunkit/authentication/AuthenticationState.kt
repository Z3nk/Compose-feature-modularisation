package fr.zunkit.authentication

data class AuthenticationState(
    val label: String = "",
    var emailAddress: String = "",
    val password: String = "",
    val isAuthenticationContentValid: Boolean = false,
    val isLoading: Boolean = false,
    val success: Boolean? = null,
    val errorMessage: String? = null
)