package com.lynnkale.todoallthethings.newtodo.event

sealed class EditTodoItemEvent {
    class OnSaveEvent(val successCallback: () -> Unit) : EditTodoItemEvent()
    class OnChangeName(val name: String) : EditTodoItemEvent()
    class OnChangeDescription(val description: String) : EditTodoItemEvent()
}
