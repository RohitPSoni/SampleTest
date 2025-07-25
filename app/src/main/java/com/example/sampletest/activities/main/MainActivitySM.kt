package com.example.sampletest.activities.main

class MainActViewState

sealed class MainActViewEffect {
    object NavigateToWebSocket : MainActViewEffect()
    object NavigateToApi : MainActViewEffect()
    object NavigateToBasketBallCourt : MainActViewEffect()
}

enum class ButtonType {
    WebSocket,
    Api,
    Court
}