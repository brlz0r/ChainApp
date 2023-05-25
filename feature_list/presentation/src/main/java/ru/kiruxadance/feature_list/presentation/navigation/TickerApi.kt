package ru.kiruxadance.feature_list.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.kiruxadance.core.feature_api.FeatureApi

interface TickerApi : FeatureApi {
}

class TickerApiImpl : TickerApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalTickerFeatureApi.registerGraph(navController, navGraphBuilder)
    }

}