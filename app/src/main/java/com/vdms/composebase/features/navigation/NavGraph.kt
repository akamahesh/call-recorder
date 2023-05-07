package com.vdms.composebase.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.vdms.composebase.features.component.RickAndMortyBottomAppBar
import com.vdms.composebase.features.component.RickAndMortyFloatingActionBar
import com.vdms.composebase.features.component.RickAndMortyScaffold
import com.vdms.composebase.features.screen.characters.navigation.charactersNavigationRoute
import com.vdms.composebase.features.screen.characters.navigation.charactersScreen
import com.vdms.composebase.features.screen.charactersdetail.navigation.charactersDetailScreen
import com.vdms.composebase.features.screen.charactersdetail.navigation.navigateCharactersDetail
import com.vdms.composebase.features.screen.episodes.navigation.episodesScreen
import com.vdms.composebase.features.screen.favorites.navigation.favoritesScreen
import com.vdms.composebase.features.screen.search.navigation.searchScreen
import com.vdms.composebase.features.screen.settings.navigation.settingsScreen
import com.vdms.composebase.utils.Utility.toJson

/**
 * Created by merttoptas on 9.03.2022
 */

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination

    RickAndMortyScaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    RickAndMortyBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        floatingActionButton = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    RickAndMortyFloatingActionBar(
                        navController = navController,
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = charactersNavigationRoute,
            Modifier.padding(innerPadding)
        ) {
            charactersScreen { navController.navigateCharactersDetail(it.toJson()) }
            charactersDetailScreen { navController.navigateUp() }
            episodesScreen()
            searchScreen { navController.navigateCharactersDetail(it.toJson()) }
            settingsScreen()
            favoritesScreen { navController.navigateCharactersDetail(it.toJson()) }
        }
    }
}
