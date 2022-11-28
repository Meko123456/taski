package com.example.tasksapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TasksDao {

    @Insert //(onConflict = OnConflictStrategy.REPLACE)
    fun insert (tasksEntity: TasksEntity)

    @Delete
    fun delete (tasksEntity: TasksEntity)

    @Query("SELECT * FROM  tasksTable WHERE id = :id")
    fun getToDoById (id: Int): TasksEntity

    @Query("SELECT * FROM  tasksTable")
    fun getTodos(): LiveData<List<TasksEntity>>
}