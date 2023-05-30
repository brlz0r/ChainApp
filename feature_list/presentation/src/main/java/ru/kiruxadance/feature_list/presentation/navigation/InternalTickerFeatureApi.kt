package ru.kiruxadance.feature_list.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.kiruxadance.core.common.navigation_constants.TickerFeature
import ru.kiruxadance.core.feature_api.FeatureApi
import ru.kiruxadance.feature_list.presentation.screen.TickerScreen
import ru.kiruxadance.feature_list.presentation.screen.TickerViewModel

internal object InternalTickerFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = TickerFeature.tickerScreenRoute, route = TickerFeature.nestedRoute) {
            composable(TickerFeature.tickerScreenRoute) {
                val viewModel = hiltViewModel<TickerViewModel>()
                TickerScreen(viewModel = viewModel, navController)
            }
        }
    }
}