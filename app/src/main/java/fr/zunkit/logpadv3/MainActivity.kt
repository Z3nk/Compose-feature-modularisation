package fr.zunkit.logpadv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.zunkit.authentication.Authentication
import fr.zunkit.authentication.AuthenticationViewModel
import fr.zunkit.logpadv3.ui.theme.LogpadV3Theme
import fr.zunkit.navigation.NavigationEvent
import fr.zunkit.navigation.NavigationManager
import fr.zunkit.navigation.features.authentications.AuthenticationDirections
import fr.zunkit.navigation.features.rfid.RfidDetailNavigation
import fr.zunkit.navigation.features.rfid.RfidDirections
import fr.zunkit.rfid_presentation.Rfid
import fr.zunkit.rfid_presentation.RfidViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogpadV3Theme {
                val navController = rememberNavController()
                HandleNavigation(navController)
                NavHost(
                    navController,
                    startDestination = AuthenticationDirections.root.destination
                ) {
                    authenticationNavigation()
                    rfidNavigation()
                }
            }
        }
    }

    @Composable
    private fun HandleNavigation(navController: NavHostController) {
        LaunchedEffect(Unit) {
            navigationManager.event.onEach {
                when (it) {
                    NavigationEvent.OnAuthentificated ->
                        navigationManager.navigate(RfidDetailNavigation.detail("titi"))
                }
            }.launchIn(this)

            navigationManager.commands.onEach {
                navController.navigate(it.destination)
            }.launchIn(this)
        }
    }
}

private fun NavGraphBuilder.authenticationNavigation() {
    navigation(
        startDestination = AuthenticationDirections.authentication.destination,
        route = AuthenticationDirections.root.destination
    ) {
        composable(
            AuthenticationDirections.authentication.destination,
            AuthenticationDirections.authentication.arguments
        ) {
            val vm = hiltViewModel<AuthenticationViewModel>()
            Authentication(
                vm
            )
        }
    }
}

private fun NavGraphBuilder.rfidNavigation() {
    navigation(
        startDestination = RfidDirections.list.destination,
        route = RfidDirections.root.destination
    ) {
        composable(
            RfidDirections.list.destination,
            RfidDirections.list.arguments
        ) {
            val vm = hiltViewModel<RfidViewModel>()
            Rfid(
                vm,
                "Rfid"
            )
        }
        composable(
            RfidDetailNavigation.destination,
            RfidDetailNavigation.arguments
        ) {
            val vm = hiltViewModel<RfidViewModel>()
            Rfid(
                vm,
                it.arguments?.getString(RfidDetailNavigation.PARAM_NAME) ?: ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LogpadV3Theme {
//        Greeting("Android")
    }
}
