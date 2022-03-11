package fr.zunkit.navigation.features.rfid

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import fr.zunkit.navigation.NavigationCommand

object RfidDetailNavigation {
    const val PARAM_NAME = "deviceId"
    private const val ROUTE_PATH = "rfid-reader-detail"

    val destination = "$ROUTE_PATH/{$PARAM_NAME}"

    val arguments = listOf(
        navArgument(PARAM_NAME) { type = NavType.StringType }
    )

    fun detail(
        deviceId: String? = null
    ) = object : NavigationCommand {
        override val arguments = RfidDetailNavigation.arguments

        override val destination = "$ROUTE_PATH/$deviceId"
    }



    val detail = object : NavigationCommand {

        override val arguments = RfidDetailNavigation.arguments

        override val destination = "$ROUTE_PATH/toto"
    }
}