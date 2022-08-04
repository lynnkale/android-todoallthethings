package com.lynnkale.todoallthethings.todolist.repository

import com.lynnkale.todoallthethings.todolist.datasource.ToDoItemLocalDataSource
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val dataSource: ToDoItemLocalDataSource
){
    suspend fun getItems(): List<ToDoItemEntity> {
        return dataSource.local.getIncomplete()
    }

    suspend fun getCompletedItems(): List<ToDoItemEntity> {
        return dataSource.local.getComplete()
    }

    suspend fun getItem(id: Int): ToDoItemEntity {
        return dataSource.local.get(id)
    }

    suspend fun saveItem(item: ToDoItemEntity) {
        return if (item.id > 0) {
            dataSource.local.update(item)
        } else {
            dataSource.local.insert(item)
        }
    }
}
