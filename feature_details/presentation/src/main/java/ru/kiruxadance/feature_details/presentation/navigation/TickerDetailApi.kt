package ru.kiruxadance.feature_details.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.kiruxadance.core.feature_api.FeatureApi

interface TickerDetailApi: FeatureApi {
}

class TickerDetailsApiImpl: TickerDetailApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalTickerDetailApi.registerGraph(navController, navGraphBuilder)
    }
}