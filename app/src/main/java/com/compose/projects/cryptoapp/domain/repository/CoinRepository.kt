package com.compose.projects.cryptoapp.domain.repository

import com.editor.crypto.data.remote.dto.CoinDetailDto
import com.editor.crypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinByID(coinID: String) : CoinDetailDto
}