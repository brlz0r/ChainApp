package ru.kiruxadance.chainapp.navigation

import ru.kiruxadance.feature_details.presentation.navigation.TickerDetailApi
import ru.kiruxadance.feature_list.presentation.navigation.TickerApi

data class NavigationProvider(
    val tickerApi: TickerApi,
    val tickerDetailApi: TickerDetailApi
)
