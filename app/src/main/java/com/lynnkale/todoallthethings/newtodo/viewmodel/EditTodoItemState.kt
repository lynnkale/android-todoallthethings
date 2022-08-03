package com.lynnkale.todoallthethings.newtodo.viewmodel

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

data class EditTodoItemState(
    val item: ToDoItemEntity,
    val errors: Map<String, List<Int>> = emptyMap(),
    val saved: Boolean = false,
)
