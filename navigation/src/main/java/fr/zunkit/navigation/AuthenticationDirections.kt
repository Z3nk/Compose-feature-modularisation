package fr.zunkit.navigation

import androidx.navigation.NamedNavArgument


object AuthenticationDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "connect"

    }

    val authentication  = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "authentication"

    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""

    }

    val rfid = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "rfid"
    }

    val forgotPassword = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "forgot_password"

    }
}