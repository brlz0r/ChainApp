package ru.kiruxadance.feature_list.domain.model

data class Ticker(
    val last_trade_price: Double,
    val price_24h: Double,
    val symbol: String,
    val volume_24h: Double
)
