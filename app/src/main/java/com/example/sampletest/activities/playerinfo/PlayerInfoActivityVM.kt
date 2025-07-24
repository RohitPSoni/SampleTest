package com.example.sampletest.activities.playerinfo

import androidx.lifecycle.viewModelScope
import com.example.presentation.usecase.GetPlayersDataUseCase
import com.example.sampletest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerInfoActivityVM @Inject constructor(
    private val getPlayersDataUseCase: GetPlayersDataUseCase
) : BaseViewModel<PlayerInfoState, PlayerInfoEffect>() {

    init {
        viewState = PlayerInfoState()
        getAllPlayersData()
    }

    private fun getAllPlayersData() {
        viewModelScope.launch {
            val playersList = getPlayersDataUseCase()
            viewState = viewState.copy(playerInfoList = playersList)
        }
    }
}