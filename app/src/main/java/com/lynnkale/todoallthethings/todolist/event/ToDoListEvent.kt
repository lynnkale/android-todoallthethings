package com.lynnkale.todoallthethings.todolist.event

sealed class ToDoListEvent {
    class OnClickEvent(itemId: Int) : ToDoListEvent()
    class OnDismissEvent(itemId: Int) : ToDoListEvent()
    class OnCheckEvent(itemId: Int, checked: Boolean) : ToDoListEvent()
}
