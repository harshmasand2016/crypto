package com.compose.projects.cryptoapp.domain.model

import com.editor.crypto.data.remote.dto.Tag
import com.editor.crypto.data.remote.dto.TeamMember

data class CoinDetail(
    val coinID: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val logo: String
)
