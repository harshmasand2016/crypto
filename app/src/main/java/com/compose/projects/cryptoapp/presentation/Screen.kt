package com.compose.projects.cryptoapp.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_List")
    object CoinDetailsScreen : Screen("coin_details")
}
