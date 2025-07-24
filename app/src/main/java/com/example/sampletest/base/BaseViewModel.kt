package com.example.sampletest.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class BaseViewModel<STATE, EFFECT> : ViewModelBase<STATE, EFFECT>() {
    private val _viewStates: MutableStateFlow<STATE> by lazy { MutableStateFlow(viewState) }
    override val viewStates: StateFlow<STATE>
        get() = _viewStates

    private var _viewState: STATE? = null
    protected var viewState: STATE
        get() = _viewState
            ?: throw UninitializedPropertyAccessException("viewState queried before initialized")
        set(value) {
            _viewState = value
            _viewStates.value = value
        }

    override val viewEffects: Flow<EFFECT>
        get() = _viewEffects.receiveAsFlow()

    /**
     * With channel, each event will be sent to only 1 subscriber
     * An attempt to post an event without subscriber will suspend as soon as the channel buffer
     * becomes full, waiting for subscriber to appear. Posted events will not be dropped.
     */
    private val _viewEffects: Channel<EFFECT> = Channel(
        capacity = Channel.BUFFERED,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
        onUndeliveredElement = {}
    )
    private var _viewEffect: EFFECT?=null
    protected var viewEffect: EFFECT
        get() = _viewEffect
            ?: throw UninitializedPropertyAccessException("viewEffect queried before initialized")
        set(value) {
            _viewEffect = value
            viewModelScope.launch { _viewEffects.send(value) }
        }
}

abstract class ViewModelBase<STATE, EFFECT> : ViewModel() {
    abstract val viewStates: StateFlow<STATE>
    abstract val viewEffects: Flow<EFFECT>
}