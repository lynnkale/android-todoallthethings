package com.lynnkale.todoallthethings.todolist.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lynnkale.todoallthethings.todolist.model.ToDoItemEntity

@Dao
interface ToDoItemDao {
    @Insert
    suspend fun insert(item: ToDoItemEntity)

    @Update(entity = ToDoItemEntity::class)
    suspend fun update(item: ToDoItemEntity)

    @Delete
    suspend fun delete(item: ToDoItemEntity)

    @Query("SELECT * FROM todo_item ORDER BY created ASC")
    suspend fun getAll(): List<ToDoItemEntity>

    @Query("SELECT * FROM todo_item WHERE id = :id ORDER BY created ASC")
    suspend fun get(id: Int): ToDoItemEntity

    @Query("SELECT * FROM todo_item WHERE isDismissed = 0 AND isCompleted = 0 ORDER BY created ASC")
    suspend fun getIncomplete(): List<ToDoItemEntity>

    @Query("SELECT * FROM todo_item WHERE isDismissed = 0 AND isCompleted = 1 ORDER BY created ASC")
    suspend fun getComplete(): List<ToDoItemEntity>
}
