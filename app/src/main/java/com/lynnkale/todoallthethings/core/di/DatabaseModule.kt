package com.lynnkale.todoallthethings.core.di

import android.content.Context
import androidx.room.Room
import com.lynnkale.todoallthethings.core.data.ToDoDatabase
import com.lynnkale.todoallthethings.todolist.dao.ToDoItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase::class.java, "todo.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideToDoDatabase(database: ToDoDatabase): ToDoItemDao {
        return database.todoItemDao
    }
}
