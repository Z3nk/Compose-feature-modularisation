package fr.zunkit.authentication

class AuthenticationState(
    val emailAddress: String = "",
    val password: String = "",
    val isAuthenticationContentValid: Boolean = false,
    val isLoading: Boolean = false,
    val success: Boolean? = null,
    val errorMessage: String? = null
) {

    companion object {
        fun initialise(): AuthenticationState = AuthenticationState()
    }

    fun build(block: Builder.() -> Unit) = Builder(this).apply(block).build()

    class Builder(state: AuthenticationState) {
        var userEmail = state.emailAddress
        var userPassword = state.password
        var isAuthenticationContentValid = userEmail.trim().isNotEmpty() &&
                userPassword.trim().isNotEmpty()
        var loading = state.isLoading
        var success = state.success
        var error = state.errorMessage

        fun build(): AuthenticationState {
            return AuthenticationState(
                userEmail,
                userPassword,
                isAuthenticationContentValid,
                loading,
                success,
                error
            )
        }
    }
}