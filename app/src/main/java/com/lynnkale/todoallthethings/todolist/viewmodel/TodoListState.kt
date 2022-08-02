package com.lynnkale.todoallthethings.todolist.viewmodel

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

data class TodoListState(
    val todoItems: List<ToDoItemEntity> = emptyList()
)
