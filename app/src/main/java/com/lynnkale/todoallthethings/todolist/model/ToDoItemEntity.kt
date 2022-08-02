package com.lynnkale.todoallthethings.todolist.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "todo_item", indices = [Index(value = ["isDismissed", "isCompleted"])])
data class ToDoItemEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String? = null,
    val isDismissed: Boolean = false,
    val isCompleted: Boolean = false,
    val created: Long = Instant.now().epochSecond
) {
    companion object {
        fun mock(id: Int = 1): ToDoItemEntity {
            return ToDoItemEntity(id, "Name", "Description!", false, false)
        }

        fun mockList(): List<ToDoItemEntity> {
            return (1..5).map { mock(it) }
        }
    }
}
