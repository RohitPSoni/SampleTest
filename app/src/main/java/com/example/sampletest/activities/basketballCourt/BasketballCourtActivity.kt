package com.example.sampletest.activities.basketballCourt

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.sampletest.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketballCourtActivity: BaseActivity<BasketballCourtState, BasketballCourtEffect, BasketballCourtVM>() {
    override val viewModel: BasketballCourtVM by viewModels()

    companion object{
        fun getIntent(context: Context) = Intent(context, BasketballCourtActivity::class.java)
    }

    @Composable
    override fun ComposeViewState(viewState: BasketballCourtState) {
        super.ComposeViewState(viewState)
        BaskeballScene()
    }
}