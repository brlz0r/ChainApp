package ru.kiruxadance.feature_details.domain.model

data class TickerDetail(
    val last_trade_price: Double,
    val price_24h: Double,
    val symbol: String,
    val volume_24h: Double
)
