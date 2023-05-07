@file:OptIn(ExperimentalAnimationApi::class)

package com.vdms.composebase.features.screen.login.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.vdms.composebase.features.screen.login.LoginScreen

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(
    navOptions: NavOptions? = null
) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen() {
    composable(loginNavigationRoute) {
        LoginScreen()
    }
}