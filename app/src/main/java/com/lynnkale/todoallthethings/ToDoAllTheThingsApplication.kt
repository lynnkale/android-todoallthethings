package com.lynnkale.todoallthethings

import android.app.Application
import com.lynnkale.todoallthethings.todolist.repository.ToDoRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ToDoAllTheThingsApplication : Application() {
    @Inject
    lateinit var todoRepository: ToDoRepository
}
