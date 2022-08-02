package com.lynnkale.todoallthethings.core.navigation

import com.lynnkale.todoallthethings.ToDoListDestination
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class Navigator {
    private val _sharedFlow =
        MutableSharedFlow<ToDoListDestination>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(navTarget: ToDoListDestination) {
        _sharedFlow.tryEmit(navTarget)
    }


}
