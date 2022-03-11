package fr.zunkit.navigation

import fr.zunkit.navigation.features.authentications.AuthenticationDirections.default
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {

    var _commands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 1)
    var commands = _commands.asSharedFlow()

    var _event = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    val event = _event.asSharedFlow()

    fun event(
        directions: NavigationEvent
    ) {
        _event.tryEmit(directions)
    }

    fun navigate(
        navigationCommand: NavigationCommand
    ) {
        _commands.tryEmit(navigationCommand)
    }

}