package com.example.sampletest.activities.playerinfo

import com.example.presentation.usecase.uiState.PlayerInfo

data class PlayerInfoState(
    val playerInfoList: List<PlayerInfo> = mutableListOf()
)

class PlayerInfoEffect