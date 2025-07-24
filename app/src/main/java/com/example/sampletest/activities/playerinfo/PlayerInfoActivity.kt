package com.example.sampletest.activities.playerinfo

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sampletest.activities.playerinfo.ui.PlayerInfoCard
import com.example.sampletest.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerInfoActivity : BaseActivity<PlayerInfoState, PlayerInfoEffect, PlayerInfoActivityVM>() {

    companion object {
        fun getIntent(context: Context) = Intent(context, PlayerInfoActivity::class.java)
    }

    override val viewModel: PlayerInfoActivityVM by viewModels()

    @Composable
    override fun ComposeViewState(viewState: PlayerInfoState) {
        super.ComposeViewState(viewState)
        Scaffold(
            modifier = Modifier.systemBarsPadding()
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier.padding(contentPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(viewState.playerInfoList.size) {
                    PlayerInfoCard(viewState.playerInfoList[it])
                }
            }
        }
    }
}