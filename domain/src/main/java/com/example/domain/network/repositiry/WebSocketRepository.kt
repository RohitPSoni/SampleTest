package com.example.domain.network.repositiry

import com.example.domain.network.data.WebSocketEvent
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

interface WebSocketRepository {
    fun connect(url: String): Flow<WebSocketEvent>
    fun sendMessage(message: String)
}

class WebSocketRepositoryImpl @Inject constructor(
    private val okHttpClient: OkHttpClient
) : WebSocketRepository {
    private var webSocket: WebSocket? = null
    override fun connect(url: String): Flow<WebSocketEvent> = callbackFlow {
        val listner = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                trySend(WebSocketEvent.Open)
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                trySend(WebSocketEvent.OnMessage(text))
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                trySend(WebSocketEvent.OnClosed)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                trySend(WebSocketEvent.OnClosing(code = code, reason = reason))
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                trySend(
                    WebSocketEvent.OnFailure(
                        th = t, response = response
                    )
                )
            }
        }

        val request = Request.Builder().url(url).build()
        okHttpClient.newWebSocket(request, listner)

        awaitClose {
            webSocket?.close(-1, "Connection closed by client")
        }
    }

    override fun sendMessage(message: String) {
        webSocket?.send(message)
    }

}
