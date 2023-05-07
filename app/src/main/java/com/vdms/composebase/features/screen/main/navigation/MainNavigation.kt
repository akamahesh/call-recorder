@file:OptIn(ExperimentalAnimationApi::class)

package com.vdms.composebase.features.screen.main.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.vdms.composebase.features.screen.UserInfo
import com.vdms.composebase.features.screen.login.navigation.navigateToLogin
import com.vdms.composebase.features.screen.main.MainScreen
import com.vdms.composebase.features.screen.settings.navigation.navigateToSettings

const val mainNavigationRoute = "main_route"

fun NavController.navigateToMain(
    navOptions: NavOptions? = null,
) {
    this.navigate(mainNavigationRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(navigateLogin: () -> Unit, navigateSettings: () -> Unit) {
    composable(
        mainNavigationRoute,
        content = {
            MainScreen(
                userInfo = UserInfo(),
                navigateLogin = { navigateLogin.invoke() },
                navigateSettings = { navigateSettings.invoke() })
        }
    )
}