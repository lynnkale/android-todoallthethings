package com.lynnkale.todoallthethings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import com.lynnkale.todoallthethings.newtodo.ui.NewItemModal
import com.lynnkale.todoallthethings.todolist.event.ToDoListEvent
import com.lynnkale.todoallthethings.todolist.ui.ToDoList
import com.lynnkale.todoallthethings.todolist.viewmodel.TodoListViewModel

interface ToDoListDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

object List : ToDoListDestination {
    override val icon = Icons.Filled.List
    override val route = "active-list"
    override val screen: @Composable () -> Unit = {
        val viewModel = hiltViewModel<TodoListViewModel>()
        ToDoList(
            items = viewModel.state.value.todoItems,
            closeAction = { },
            checkAction = { id, checked ->
                viewModel.eventListener(
                    ToDoListEvent.OnCheckEvent(
                        id,
                        checked
                    )
                )
            },
            clickAction = { },
        )
    }
}

object New : ToDoListDestination {
    override val icon = Icons.Filled.Add
    override val route = "add-item"
    override val screen: @Composable () -> Unit = {
        NewItemModal(
            onSave = { }
        )
    }
}
