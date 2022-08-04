package com.lynnkale.todoallthethings.completed.domain

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import javax.inject.Inject

class  GetCompletedItemsUseCase @Inject constructor(
private val repository: ToDoRepository
) {
    suspend operator fun invoke(): List<ToDoItemEntity> {
        return repository.getCompletedItems()
    }
}
