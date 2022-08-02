package com.lynnkale.todoallthethings.newtodo.event

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

sealed class EditTodoItemEvent {
    class OnSaveEvent(val item: ToDoItemEntity) : EditTodoItemEvent()
}
