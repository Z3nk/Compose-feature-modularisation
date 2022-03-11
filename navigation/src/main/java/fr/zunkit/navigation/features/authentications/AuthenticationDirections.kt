package fr.zunkit.navigation.features.authentications

import androidx.navigation.NamedNavArgument
import fr.zunkit.navigation.NavigationCommand


object AuthenticationDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "connect"

    }

    val authentication  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "authentication"

    }

    val default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""
    }
}