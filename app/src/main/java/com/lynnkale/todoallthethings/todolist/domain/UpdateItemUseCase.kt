package com.lynnkale.todoallthethings.todolist.domain

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import javax.inject.Inject

class UpdateItemUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(item: ToDoItemEntity) {
        return repository.saveItem(item)
    }
}
