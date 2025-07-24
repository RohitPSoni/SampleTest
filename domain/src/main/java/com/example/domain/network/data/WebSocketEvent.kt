package com.example.domain.network.data

import okhttp3.Response


sealed class WebSocketEvent {
    object Open : WebSocketEvent()
    data class OnMessage(val message: String) : WebSocketEvent()
    data class OnClosing(val code: Int, val reason: String) : WebSocketEvent()
    data class OnFailure(val th: Throwable, val response: Response?) : WebSocketEvent()
    object OnClosed : WebSocketEvent()
}