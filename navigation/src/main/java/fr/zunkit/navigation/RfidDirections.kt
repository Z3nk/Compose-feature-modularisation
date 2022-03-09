package fr.zunkit.navigation

import androidx.navigation.NamedNavArgument

object RfidDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home"

    }

    val connection = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "connection"
    }
}