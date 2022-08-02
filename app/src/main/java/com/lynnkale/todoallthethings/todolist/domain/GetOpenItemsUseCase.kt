package com.lynnkale.todoallthethings.todolist.domain

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import javax.inject.Inject

class GetOpenItemsUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(

    ): List<ToDoItemEntity> {
        return repository.getItems()
    }
}
