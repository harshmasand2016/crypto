package com.compose.projects.cryptoapp.presentation.coindetails

import com.compose.projects.cryptoapp.domain.model.CoinDetail

data class CoinDetailsState(
    val isLoading : Boolean = false,
    val coin: CoinDetail? = null,
    val error: String =""
)