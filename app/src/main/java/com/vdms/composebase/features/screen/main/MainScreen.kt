package com.vdms.composebase.features.screen.main

import com.vdms.composebase.features.screen.login.LoginScreen
import com.vdms.composebase.features.screen.UserInfo
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.Model
import androidx.compose.state
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import com.vdms.composebase.data.model.FavoriteEntity
import com.vdms.composebase.features.screen.settings.navigation.navigateToSettings
import com.vdms.composebase.features.screen.login.navigation.navigateToLogin

@Composable
fun MainScreen(userInfo: UserInfo= UserInfo(), navigateLogin: () -> Unit, navigateSettings: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  if (!userInfo.userLoggedIn) Route.LOGIN else Route.SETTINGS
    ) {

        composable(Route.LOGIN) { backStackEntry ->
            navigateLogin.invoke()
        }
        composable(Route.SETTINGS) { backStackEntry ->
           navigateSettings.invoke()
        }




        composable(Route.USER) {
/*            UsersScreen(
                onUserClick = { username ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                        navController.navigate("${Route.DETAIL}/$username")
                    }
                }
            )*/
        }
        composable(
            route = "${Route.DETAIL}/{${Argument.USERNAME}}",
            arguments = listOf(
                navArgument(Argument.USERNAME) {
                    type = NavType.StringType
                }
            ),
        ) {
            navController.navigateToSettings(null)
        }
    }
}

object Route {
    const val LOGIN = "login"
    const val DETAIL = "detail"
    const val USER = "user"
    const val SETTINGS = "settings"
}

object Argument {
    const val USERNAME = "username"
}