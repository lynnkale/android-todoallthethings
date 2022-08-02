package com.lynnkale.todoallthethings.todolist.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynnkale.todoallthethings.todolist.domain.GetOpenItemsUseCase
import com.lynnkale.todoallthethings.todolist.domain.UpdateItemUseCase
import com.lynnkale.todoallthethings.todolist.event.ToDoListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val getItems: GetOpenItemsUseCase,
    private val updateItem: UpdateItemUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(TodoListState())
    val state: State<TodoListState>
        get() = _state

    init {
        listenToItems()
    }

    private fun listenToItems() {
        viewModelScope.launch {
            val items = getItems.invoke()
            _state.value = _state.value.copy(todoItems = items)
        }
    }

    fun eventListener(event: ToDoListEvent) {
        when (event) {
            is ToDoListEvent.OnClickEvent -> {
                handleOnClick(event)
            }
            is ToDoListEvent.OnCheckEvent -> {
                handleOnCheck(event)
            }
            is ToDoListEvent.OnDismissEvent -> {
                handleDismiss(event)
            }
        }
    }

    private fun handleOnClick(event: ToDoListEvent.OnClickEvent) {
        Log.d(TAG, "handleOnClick")
        // TODO
    }

    private fun handleOnCheck(event: ToDoListEvent.OnCheckEvent) {
        Log.d(TAG, "handleOnCheck")
        val updatedItem = event.item.copy(isCompleted = event.checked)
        viewModelScope.launch {
            delay(500)
            updateItem.invoke(updatedItem)
            listenToItems()
        }
    }

    private fun handleDismiss(event: ToDoListEvent.OnDismissEvent) {
        Log.d(TAG, "handleDismiss")
        // TODO
    }

    companion object {
        const val TAG = "TodoListViewModel"
    }
}
