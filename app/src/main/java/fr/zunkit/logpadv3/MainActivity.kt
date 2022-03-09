package fr.zunkit.logpadv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.zunkit.authentication.Authentication
import fr.zunkit.authentication.AuthenticationViewModel
import fr.zunkit.logpadv3.ui.theme.LogpadV3Theme
import fr.zunkit.navigation.AuthenticationDirections
import fr.zunkit.navigation.NavigationManager
import fr.zunkit.navigation.RfidDirections
import fr.zunkit.rfid_presentation.Rfid
import fr.zunkit.rfid_presentation.RfidViewModel
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
                navigationManager.commands.collectAsState().value.also { command ->
                    if (command.destination.isNotEmpty()) {
                        navController.navigate(command.destination)
                    }
                }
                NavHost(
                    navController,
                    startDestination = AuthenticationDirections.root.destination
                ) {
                    navigation(
                        startDestination = AuthenticationDirections.authentication.destination,
                        route = AuthenticationDirections.root.destination
                    ) {
                        composable(AuthenticationDirections.authentication.destination) {
                            val vm = hiltViewModel<AuthenticationViewModel>()
                            Authentication(
                                vm
                            )
                        }
                    }
                    navigation(
                        startDestination = AuthenticationDirections.forgotPassword.destination,
                        route = RfidDirections.root.destination
                    ) {
                        composable(AuthenticationDirections.Success.destination) {
                            val vm = hiltViewModel<RfidViewModel>()
                            Rfid(
                                vm
                            )
                        }
                    }
                }

                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
////                    Greeting("Android")
//                }
            }
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