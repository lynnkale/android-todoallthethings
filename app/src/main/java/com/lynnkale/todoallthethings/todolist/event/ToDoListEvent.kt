package com.lynnkale.todoallthethings.todolist.event

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

sealed class ToDoListEvent {
    class OnClickEvent(val item: ToDoItemEntity) : ToDoListEvent()
    class OnDismissEvent(val item: ToDoItemEntity) : ToDoListEvent()
    class OnCheckEvent(val item: ToDoItemEntity, val checked: Boolean) : ToDoListEvent()
}
