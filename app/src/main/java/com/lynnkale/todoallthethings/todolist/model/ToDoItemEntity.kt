package com.lynnkale.todoallthethings.todolist.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "todo_item", indices = [Index(value = ["isDismissed", "isCompleted"])])
data class ToDoItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String = "",
    val description: String? = null,
    val isDismissed: Boolean = false,
    val isCompleted: Boolean = false,
    val created: Long = Instant.now().epochSecond
) {
    companion object {
        fun mock(id: Int = 1): ToDoItemEntity {
            return ToDoItemEntity(id, "Name $id", "Description!", false, false)
        }

        fun mockList(): List<ToDoItemEntity> {
            return (1..5).map { mock(it) }
        }
    }
}

class ToDoItem(
    var id: Int,
    var name: String,
    var description: String,
    var isDismissed: Boolean,
    var isCompleted: Boolean,
    var created: Instant,
) {

    fun toEntity(): ToDoItemEntity {
        return ToDoItemEntity(
            id = id,
            name = name,
            description = description.ifEmpty { null },
            isDismissed = isDismissed,
            isCompleted = isCompleted,
            created = created.epochSecond,
        )
    }

    companion object {
        const val FIELD_NAME = "name"
        const val FIELD_DESCRIPTION = "description"

        fun fromEntity(entity: ToDoItemEntity): ToDoItem {
            return ToDoItem(
                id = entity.id,
                name = entity.name,
                description = entity.description ?: "",
                isDismissed = entity.isDismissed,
                isCompleted = entity.isCompleted,
                created = Instant.ofEpochSecond(entity.created),
            )
        }
    }
}
