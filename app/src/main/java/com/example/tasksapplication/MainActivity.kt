package com.example.tasksapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tasksapplication.data.TasksDao
import com.example.tasksapplication.data.TasksEntity
import com.example.tasksapplication.databinding.ActivityMainBinding
import com.example.tasksapplication.domain.TasksViewModel
import com.example.tasksapplication.ui.TasksRVAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var vm: TasksViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskAdapter = TasksRVAdapter()
        vm = ViewModelProvider(this)[TasksViewModel::class.java]
        val texti = vm.dao


        vm.getAllTasks.observe(this) {
            taskAdapter.submitList(it)
        }

        binding.apply {
            tvRecycler.adapter = taskAdapter
            btnAdd.setOnClickListener {
                addRecord(texti)
                tvName.visibility = View.INVISIBLE
            }
        }
    }
    private fun addRecord(tasksDao: TasksDao) {
        val taski = binding.editText.text.toString()

        if (taski.isNotEmpty()) {
            tasksDao.insert(TasksEntity(taski))
            binding.editText.text.clear()
        } else {
            Toast.makeText(
                this,
                "taski cannot be blank",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
