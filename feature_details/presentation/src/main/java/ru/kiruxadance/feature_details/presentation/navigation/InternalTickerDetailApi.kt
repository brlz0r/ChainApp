package ru.kiruxadance.feature_details.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.kiruxadance.core.common.navigation_constants.TickerDetailsFeature
import ru.kiruxadance.core.feature_api.FeatureApi
import ru.kiruxadance.feature_details.presentation.screen.TickerDetailScreen
import ru.kiruxadance.feature_details.presentation.screen.TickerDetailViewModel

object InternalTickerDetailApi : FeatureApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            route = TickerDetailsFeature.nestedRoute,
            startDestination = TickerDetailsFeature.tickerDetailsScreenRoute)
        {
            composable(TickerDetailsFeature.tickerDetailsScreenRoute) {
                val symbol = it.arguments?.getString("symbol")
                val viewModel = hiltViewModel<TickerDetailViewModel>()
                TickerDetailScreen(symbol = symbol.toString(), viewModel = viewModel)
            }
        }
    }
}