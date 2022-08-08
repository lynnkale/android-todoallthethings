package com.lynnkale.todoallthethings.edittodo.event

sealed class EditTodoItemEvent {
    class OnSaveEvent(val successCallback: () -> Unit) : EditTodoItemEvent()
    class OnChangeName(val name: String) : EditTodoItemEvent()
    class OnChangeDescription(val description: String) : EditTodoItemEvent()
}
