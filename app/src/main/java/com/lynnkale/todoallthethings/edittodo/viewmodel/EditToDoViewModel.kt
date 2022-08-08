package com.lynnkale.todoallthethings.edittodo.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynnkale.todoallthethings.R
import com.lynnkale.todoallthethings.core.navigation.Edit
import com.lynnkale.todoallthethings.edittodo.domain.GetItemUseCase
import com.lynnkale.todoallthethings.edittodo.domain.SaveItemUseCase
import com.lynnkale.todoallthethings.edittodo.event.EditTodoItemEvent
import com.lynnkale.todoallthethings.todolist.model.ToDoItem
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditToDoViewModel @Inject constructor(
    private val saveItem: SaveItemUseCase,
    private val getItem: GetItemUseCase,
    private val handle: SavedStateHandle
) : ViewModel() {

    private val _viewState = mutableStateOf(EditTodoItemState(item = ToDoItemEntity(), isNew = true))
    val viewState: State<EditTodoItemState>
        get() = _viewState

    init {
        viewModelScope.launch {
            val taskId = handle.get<Int>(Edit.idArgument)
            taskId?.let {

                val item = getItem.invoke(it)
                _viewState.value = _viewState.value.copy(item = item, isNew = false)
            }
        }
    }

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
        if (_viewState.value.item.name.isEmpty()) {
            errorMessages.add(R.string.name_value_required)
            errors[ToDoItem.FIELD_NAME] = errorMessages.toList()
        }
        _viewState.value = _viewState.value.copy(errors = errors)

        return errorMessages.isEmpty()
    }

    private fun handleSave(event: EditTodoItemEvent.OnSaveEvent) {
        if (isValid()) {
            viewModelScope.launch {
                saveItem.invoke(_viewState.value.item)
                event.successCallback()
            }
        }
    }

    private fun handleChangeName(event: EditTodoItemEvent.OnChangeName) {
        val item = ToDoItem.fromEntity(_viewState.value.item)
        item.name = event.name
        _viewState.value = _viewState.value.copy(item = item.toEntity())
    }

    private fun handleChangeDescription(event: EditTodoItemEvent.OnChangeDescription) {
        val item = ToDoItem.fromEntity(_viewState.value.item)
        item.description = event.description
        _viewState.value = _viewState.value.copy(item = item.toEntity())
    }
}
