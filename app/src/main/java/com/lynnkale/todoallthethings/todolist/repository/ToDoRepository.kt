package com.lynnkale.todoallthethings.todolist.repository

import com.lynnkale.todoallthethings.todolist.datasource.ToDoItemLocalDataSource
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val dataSource: ToDoItemLocalDataSource
){
    suspend fun getItems(): List<ToDoItemEntity> {
        return dataSource.local.getAll()
    }
}
