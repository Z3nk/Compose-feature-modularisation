package fr.zunkit.navigation

import fr.zunkit.navigation.AuthenticationDirections.Default
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow(Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}