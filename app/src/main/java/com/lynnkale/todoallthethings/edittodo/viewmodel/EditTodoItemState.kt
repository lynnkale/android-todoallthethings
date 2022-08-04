package com.lynnkale.todoallthethings.edittodo.viewmodel

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

data class EditTodoItemState(
    val item: ToDoItemEntity,
    val errors: Map<String, List<Int>> = emptyMap(),
    val saved: Boolean = false,
    val isNew: Boolean = false,
)
