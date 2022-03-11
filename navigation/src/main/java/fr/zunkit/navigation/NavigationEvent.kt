package fr.zunkit.navigation

sealed class NavigationEvent {
    object Nothing: NavigationEvent()
    object OnAuthentificated : NavigationEvent()
}