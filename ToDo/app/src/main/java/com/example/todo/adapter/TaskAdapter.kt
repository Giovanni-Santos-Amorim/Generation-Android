package com.example.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.CardLayoutBinding
import com.example.todo.model.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    var taskList = emptyList<Task>()

    class TaskViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return  TaskViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.tvName.text = task.name
        holder.binding.tvDescription.text = task.description
        holder.binding.tvResponsible.text = task.responsible
        holder.binding.tvData.text = task.data
        holder.binding.switch1.isChecked = task.status
        holder.binding.tvCategory.text = task.category.description


    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setList(list: List<Task>){

        taskList = list
        notifyDataSetChanged()

    }

}