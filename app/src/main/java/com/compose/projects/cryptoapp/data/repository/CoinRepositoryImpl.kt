package com.compose.projects.cryptoapp.data.repository

import com.compose.projects.cryptoapp.data.remote.CoinApiService
import com.editor.crypto.data.remote.dto.CoinDetailDto
import com.editor.crypto.data.remote.dto.CoinDto
import com.compose.projects.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApiService
) : CoinRepository {


    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinByID(coinID: String): CoinDetailDto {
        return api.getCoinByID(coinID)
    }
}