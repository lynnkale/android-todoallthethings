package com.lynnkale.todoallthethings.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lynnkale.todoallthethings.todolist.dao.ToDoItemDao
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

@TypeConverters()
@Database(
    entities = [ToDoItemEntity::class],
    version = 1
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract val todoItemDao: ToDoItemDao
}
