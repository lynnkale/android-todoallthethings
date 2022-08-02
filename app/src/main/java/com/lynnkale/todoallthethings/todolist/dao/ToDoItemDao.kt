package com.lynnkale.todoallthethings.todolist.dao

import androidx.room.*
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

@Dao
interface ToDoItemDao {
    @Insert
    suspend fun insertAll(vararg items: ToDoItemEntity)

    @Update
    suspend fun update(vararg items: ToDoItemEntity)

    @Delete
    suspend fun delete(item: ToDoItemEntity)

    @Query("SELECT * FROM todo_item ORDER BY created ASC")
    suspend fun getAll(): List<ToDoItemEntity>

    @Query("SELECT * FROM todo_item WHERE isDismissed = 0 AND isCompleted = 0 ORDER BY created ASC")
    suspend fun getIncomplete(): List<ToDoItemEntity>

    @Query("SELECT * FROM todo_item WHERE isDismissed = 0 AND isCompleted = 1 ORDER BY created ASC")
    suspend fun getComplete(): List<ToDoItemEntity>

}
