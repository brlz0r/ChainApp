package ru.kiruxadance.feature_details.presentation.screen

import ru.kiruxadance.feature_details.domain.model.TickerDetail

data class TickerDetailStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: TickerDetail? = null
)
