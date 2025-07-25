package com.example.sampletest.activities.main

import com.example.sampletest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(): BaseViewModel<MainActViewState, MainActViewEffect>() {
    // Always initialise viewState in init block of viewModel
    init {
        viewState = MainActViewState()
    }

    fun onButtonClicked(type: ButtonType) {
        viewEffect = when(type) {
            ButtonType.WebSocket -> MainActViewEffect.NavigateToWebSocket
            ButtonType.Api -> MainActViewEffect.NavigateToApi
            ButtonType.Court -> MainActViewEffect.NavigateToBasketBallCourt
        }
    }
}