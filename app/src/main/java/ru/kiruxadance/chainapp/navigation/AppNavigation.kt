package ru.kiruxadance.chainapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.kiruxadance.core.common.navigation_constants.TickerFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(navController = navController, startDestination = TickerFeature.nestedRoute) {
        navigationProvider.tickerApi.registerGraph(
            navController, this
        )
        navigationProvider.tickerDetailApi.registerGraph(
            navController, this
        )
    }
}