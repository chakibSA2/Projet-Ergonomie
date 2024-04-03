package com.example.familycalandar.task


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R

class TaskAdapter(private val taskList: List<Task>,
                  private val onTaskClickListener: (Task) -> Unit) : RecyclerView
                      .Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskTitle: TextView = itemView.findViewById(R.id.tv_TaskTitle)
        var taskDate: TextView = itemView.findViewById(R.id.tv_TaskDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.taskTitle.text = currentItem.taskTitle
        holder.taskDate.text = currentItem.taskDate
        holder.itemView.setOnClickListener {
            onTaskClickListener(currentItem)
        }
    }

    override fun getItemCount() = taskList.size
}