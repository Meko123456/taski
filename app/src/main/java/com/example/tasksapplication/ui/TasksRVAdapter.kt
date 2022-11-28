package com.example.tasksapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tasksapplication.data.TasksEntity
import com.example.tasksapplication.databinding.RecyclerItemVeiwBinding
import com.example.tasksapplication.ui.TasksRVAdapter.TasksViewHolder

class TasksRVAdapter :
    ListAdapter<TasksEntity, TasksViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = RecyclerItemVeiwBinding
            .inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)

    }

    class TasksViewHolder(private val binding: RecyclerItemVeiwBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: TasksEntity) {
            binding.apply {
                idTVTask.text = task.taskName
                idTVCompleted.text = task.isCompleted.toString()
            }

        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<TasksEntity>() {

        override fun areItemsTheSame(oldItem: TasksEntity, newItem: TasksEntity)
                : Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TasksEntity, newItem: TasksEntity)
                : Boolean = oldItem == newItem

    }
}