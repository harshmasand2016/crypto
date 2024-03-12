package com.editor.crypto.data.remote.dto

import com.compose.projects.cryptoapp.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id, is_active, name, rank, symbol
    )
}




