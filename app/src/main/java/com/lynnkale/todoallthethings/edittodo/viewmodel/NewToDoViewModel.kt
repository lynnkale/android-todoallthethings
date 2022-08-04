package com.lynnkale.todoallthethings.edittodo.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynnkale.todoallthethings.R
import com.lynnkale.todoallthethings.edittodo.domain.SaveItemUseCase
import com.lynnkale.todoallthethings.edittodo.event.EditTodoItemEvent
import com.lynnkale.todoallthethings.todolist.model.ToDoItem
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewToDoViewModel @Inject constructor(
    private val saveItem: SaveItemUseCase
) : ViewModel() {
    private val _state = mutableStateOf(EditTodoItemState(item = ToDoItemEntity()))
    val state: State<EditTodoItemState>
        get() = _state

    fun eventListener(event: EditTodoItemEvent) {
        when (event) {
            is EditTodoItemEvent.OnSaveEvent -> {
                handleSave(event)
            }
            is EditTodoItemEvent.OnChangeName -> {
                handleChangeName(event)
            }
            is EditTodoItemEvent.OnChangeDescription -> {
                handleChangeDescription(event)
            }
        }
    }

    private fun isValid(): Boolean {
        val errorMessages = mutableListOf<Int>()
        val errors = mutableMapOf<String, List<Int>>()
        if (_state.value.item.name.isEmpty()) {
            errorMessages.add(R.string.name_value_required)
            errors[ToDoItem.FIELD_NAME] = errorMessages.toList()
        }
        _state.value = _state.value.copy(errors = errors)

        return errorMessages.isEmpty()
    }

    private fun handleSave(event: EditTodoItemEvent.OnSaveEvent) {
        if (isValid()) {
            viewModelScope.launch {
                saveItem.invoke(_state.value.item)
                event.successCallback()
            }
        }
    }

    private fun handleChangeName(event: EditTodoItemEvent.OnChangeName) {
        val item = ToDoItem.fromEntity(_state.value.item)
        item.name = event.name
        _state.value = _state.value.copy(item = item.toEntity())
    }

    private fun handleChangeDescription(event: EditTodoItemEvent.OnChangeDescription) {
        val item = ToDoItem.fromEntity(_state.value.item)
        item.description = event.description
        _state.value = _state.value.copy(item = item.toEntity())
    }
}
