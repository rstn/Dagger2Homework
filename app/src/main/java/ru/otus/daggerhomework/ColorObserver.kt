package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface ColorObserver {

    val colorFlow: Flow<Int>

    fun fireColorEvent(@ColorInt color: Int)

}

class ColorObserverImpl : ColorObserver {

    private val _colorFlow = MutableSharedFlow<Int>(
        extraBufferCapacity = 1,
        replay = 1
    )

    override val colorFlow: Flow<Int>
        get() = _colorFlow.asSharedFlow()

    override fun fireColorEvent(color: Int) {
        _colorFlow.tryEmit(color)
    }

}