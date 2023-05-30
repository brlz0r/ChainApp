package ru.kiruxadance.feature_details.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TickerDetailScreen(
    symbol: String,
    viewModel: TickerDetailViewModel
) {
    val result = viewModel.tickerDetails.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            if(result.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            if (result.error.isNotBlank()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = result.error)
                }
            }
            result.data?.let {
                Text(text = result.data.symbol, style = MaterialTheme.typography.h3)
            }
        }
    }
}