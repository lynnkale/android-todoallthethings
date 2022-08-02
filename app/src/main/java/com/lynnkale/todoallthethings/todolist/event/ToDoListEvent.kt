package com.lynnkale.todoallthethings.todolist.event

import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

sealed class ToDoListEvent {
    class OnClickEvent(itemId: Int) : ToDoListEvent()
    class OnDismissEvent(itemId: Int) : ToDoListEvent()
    class OnCheckEvent(val item: ToDoItemEntity, val checked: Boolean) : ToDoListEvent()
}
