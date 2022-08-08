package com.lynnkale.todoallthethings.todolist.datasource

import com.lynnkale.todoallthethings.todolist.dao.ToDoItemDao
import javax.inject.Inject

class ToDoItemLocalDataSource @Inject constructor(
    val local: ToDoItemDao
)
