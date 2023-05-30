package ru.kiruxadance.feature_list.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.kiruxadance.feature_list.presentation.screen.ui.theme.DarkGrey
import ru.kiruxadance.feature_list.presentation.screen.ui.theme.Header

@Composable
fun TickerScreen(
    viewModel: TickerViewModel,
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val result = viewModel.tickerList.value
    
    Scaffold(scaffoldState = scaffoldState) {contentPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .background(DarkGrey)) {

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)) {
                Text(text = "In the past 24 hours", style = MaterialTheme.typography.h6, color = Header)
                Text(text = "Market is up", style = MaterialTheme.typography.h3, color = Color.White)

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp, vertical = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Card(backgroundColor = Color.White, shape = RoundedCornerShape(8.dp)) {
                        Text(modifier = Modifier.padding(12.dp, 8.dp), text = "All Assets")
                    }
                    Card(backgroundColor = DarkGrey,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(
                        width = 1.dp,
                        color = Header)
                    ) {
                        Text(modifier = Modifier.padding(12.dp, 8.dp), text = "Top gainers", color = Header)
                    }
                    Card(backgroundColor = DarkGrey,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Header)
                    ) {
                        Text(modifier = Modifier.padding(12.dp, 8.dp), text = "Top losers", color = Header)
                    }

                }
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
                    if (it.isEmpty()) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = "Nothing to show")
                        }
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(it) { ticker ->
                                Column(modifier = Modifier.clickable {
                                    navController.navigate("ticker_details/${ticker.symbol}")
                                }) {
                                    Row(modifier = Modifier.fillMaxWidth().padding(0.dp, 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                        Text(text = ticker.symbol, color = Color.White, style = MaterialTheme.typography.h6)
                                        Text(text = "$${ticker.last_trade_price}", color = Color.White, style = MaterialTheme.typography.h6)
                                    }
                                    Divider(color = Header)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}