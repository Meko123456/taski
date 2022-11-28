package com.example.tasksapplication.domain

import androidx.lifecycle.LiveData
import com.example.tasksapplication.data.TasksDao
import com.example.tasksapplication.data.TasksEntity

class TasksRepository(private val tasksDao: TasksDao) : TasksDao {

    //val allTasks: LiveData<List<TasksEntity>> = tasksDao.getTodos()

    override fun insert(tasksEntity: TasksEntity) {
        tasksDao.insert(tasksEntity)
    }

    override fun delete(tasksEntity: TasksEntity) {
        tasksDao.delete(tasksEntity)
    }

    override fun getToDoById(id: Int): TasksEntity {
        return tasksDao.getToDoById(id)
    }

    override fun getTodos(): LiveData<List<TasksEntity>> {
        return tasksDao.getTodos()
    }
}