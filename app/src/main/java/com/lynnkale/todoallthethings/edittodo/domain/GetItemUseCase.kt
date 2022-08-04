package com.lynnkale.todoallthethings.edittodo.domain

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import javax.inject.Inject

class GetItemUseCase  @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(itemId: Int): ToDoItemEntity {
        return repository.getItem(itemId)
    }
}
