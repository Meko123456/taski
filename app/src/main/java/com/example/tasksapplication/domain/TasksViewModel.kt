package com.example.tasksapplication.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.tasksapplication.data.TasksDataBase
import com.example.tasksapplication.data.TasksEntity

class TasksViewModel(
    application: Application,
) : AndroidViewModel(application) {


    //aq maq taskdaos metodebi
    val dao = TasksDataBase.getInstance(application).taskDao()

    val getAllTasks = dao.getTodos()


    }
