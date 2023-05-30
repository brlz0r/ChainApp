package ru.kiruxadance.feature_list.presentation.screen

import ru.kiruxadance.feature_list.domain.model.Ticker

data class TickerStateHolder(
    val isLoading: Boolean = false,
    val data: List<Ticker>? = null,
    val error: String = ""
)
