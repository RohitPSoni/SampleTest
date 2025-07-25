package com.example.sampletest.activities.websocket

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sampletest.ui.SampleButton
import com.example.sampletest.ui.SampleText
import com.example.sampletest.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebSocketActivity : BaseActivity<WebSocketState, WebSocketEffect, WebSocketVM>() {
    override val viewModel: WebSocketVM by viewModels()

    companion object {
        fun getIntent(context: Context) = Intent(context, WebSocketActivity::class.java)
    }
    @Composable
    override fun ComposeViewState(viewState: WebSocketState) {
        super.ComposeViewState(viewState)

        Scaffold(
            modifier = Modifier
                .systemBarsPadding()
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier.padding(contentPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    SampleButton(
                        charSequence = "Click on Button to Send some message",
                    ) {
                        viewModel.sendMessage("Hello from activity...")
                    }
                }
                items(viewState.messageFromServer) {
                    SampleText(
                        charSequence = it,
                        fontColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        fontSize = 14,
                    )
                }
            }
        }
    }
}