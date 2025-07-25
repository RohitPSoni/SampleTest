package com.example.sampletest.activities.main

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sampletest.activities.basketballCourt.BasketballCourtActivity
import com.example.sampletest.ui.SampleButton
import com.example.sampletest.activities.playerinfo.PlayerInfoActivity
import com.example.sampletest.activities.websocket.WebSocketActivity
import com.example.sampletest.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActViewState, MainActViewEffect, MainActivityViewModel>() {
    override val viewModel: MainActivityViewModel by viewModels()

    @Composable
    override fun ComposeViewState(viewState: MainActViewState) {
        super.ComposeViewState(viewState)

        ComposeViewEffect {
            observeViewEffect(it)
        }
        Scaffold(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
        ) { contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                SampleButton(
                    charSequence = "SocketManager"
                ) {
                    viewModel.onButtonClicked(ButtonType.WebSocket)
                }

                SampleButton(
                    modifier = Modifier.padding(top = 16.dp),
                    charSequence = "Api"
                ) {
                    viewModel.onButtonClicked(ButtonType.Api)
                }
                SampleButton(
                    modifier = Modifier.padding(top = 16.dp),
                    charSequence = "Basketball Court"
                ) {
                    viewModel.onButtonClicked(ButtonType.Court)
                }
            }
        }
    }

    private fun observeViewEffect(viewEffect: MainActViewEffect) {
        val intent = when (viewEffect) {
            is MainActViewEffect.NavigateToWebSocket -> {
                WebSocketActivity.getIntent(this)
            }

            is MainActViewEffect.NavigateToApi -> {
                PlayerInfoActivity.getIntent(this)
            }

            is MainActViewEffect.NavigateToBasketBallCourt -> {
                BasketballCourtActivity.getIntent(this)
            }
        }
        startActivity(intent)
    }
}