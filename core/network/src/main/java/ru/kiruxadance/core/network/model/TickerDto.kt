package ru.kiruxadance.core.network.model

data class TickerDto(
    val last_trade_price: Double,
    val price_24h: Double,
    val symbol: String,
    val volume_24h: Double
)