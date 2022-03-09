package fr.zunkit.navigation

import androidx.navigation.NamedNavArgument


interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}