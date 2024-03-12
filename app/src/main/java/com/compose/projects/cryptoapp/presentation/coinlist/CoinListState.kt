package com.compose.projects.cryptoapp.presentation.coinlist

import com.compose.projects.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String =""
)