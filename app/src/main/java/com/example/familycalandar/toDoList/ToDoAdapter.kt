package com.example.familycalandar.task


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R
import com.example.familycalandar.toDoList.ToDo

class ToDoAdapter(private val toDoList: List<ToDo>) : RecyclerView
.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var toDoCheck: CheckBox = itemView.findViewById(R.id.cb_ToDoCheck)
        var toDoTitle: TextView = itemView.findViewById(R.id.tv_ToDoTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        var currentItem = toDoList[position]
        holder.toDoCheck.isChecked = currentItem.isSelected
        holder.toDoTitle.text = currentItem.toDoTitle

        holder.toDoCheck.setOnClickListener {
            currentItem.isSelected = !currentItem.isSelected
        }
    }

    fun delete(task : ToDo){
        val indice = toDoList.indexOf(task)
    }

    override fun getItemCount() = toDoList.size
}