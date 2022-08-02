package com.lynnkale.todoallthethings.newtodo.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lynnkale.todoallthethings.newtodo.domain.SaveItemUseCase
import com.lynnkale.todoallthethings.newtodo.event.EditTodoItemEvent
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewToDoViewModel @Inject constructor(
    private val saveItem: SaveItemUseCase
): ViewModel() {
    private val _state = mutableStateOf(EditTodoItemState(item = ToDoItemEntity()))
    val state: State<EditTodoItemState>
        get() = _state

    init {
    }

    fun eventListener(event: EditTodoItemEvent) {
        when (event) {
            is EditTodoItemEvent.OnSaveEvent -> {
                handleSave(event)
            }
        }
    }

    private fun handleSave(event: EditTodoItemEvent.OnSaveEvent) {
        _state.value = EditTodoItemState(item = event.item)
        viewModelScope.launch {
            saveItem.invoke(_state.value.item)
        }
    }
}
