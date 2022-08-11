package com.lynnkale.todoallthethings.completed.viewmodel

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

data class CompletedListState(
    val completedItems: List<ToDoItemEntity> = emptyList()
)
