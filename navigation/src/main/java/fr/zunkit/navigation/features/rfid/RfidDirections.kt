package fr.zunkit.navigation.features.rfid

import androidx.navigation.NamedNavArgument
import fr.zunkit.navigation.NavigationCommand

object RfidDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home"

    }

    val list = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "list"
    }
}