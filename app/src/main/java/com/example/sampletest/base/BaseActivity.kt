package com.example.sampletest.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.common_ui.SampleTestTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseActivity<STATE, EFFECT, ViewModel : BaseViewModel<STATE, EFFECT>> :
    FragmentActivity() {
    abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleTestTheme {
                val viewState = viewModel.viewStates.collectAsStateWithLifecycle()
            }
        }
    }

    @CallSuper
    @Composable
    open fun ComposeViewState(viewState: STATE) {

    }

    @Composable
    open fun ComposeViewEffect(composeViewEffect: (EFFECT) -> Unit) {
        val lifecycleOwner = LocalLifecycleOwner.current
        LaunchedEffect(viewModel.viewEffects, lifecycleOwner.lifecycle) {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                withContext(Dispatchers.Main.immediate) {
                    viewModel.viewEffects.collect {
                        composeViewEffect(it)
                    }
                }
            }
        }
    }
}