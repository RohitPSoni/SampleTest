package com.example.sampletest.activities.basketballCourt

import com.example.sampletest.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketballCourtVM @Inject constructor(): BaseViewModel<BasketballCourtState, BasketballCourtEffect>(){
    init {
        viewState = BasketballCourtState()
    }
}