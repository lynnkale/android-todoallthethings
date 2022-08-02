package com.lynnkale.todoallthethings.newtodo.domain

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import javax.inject.Inject

class SaveItemUseCase @Inject constructor(
    private val repository: ToDoRepository
) {
    suspend operator fun invoke(item: ToDoItemEntity) {
        return repository.saveItem(item)
    }
}
