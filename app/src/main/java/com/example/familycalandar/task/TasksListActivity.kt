package com.example.familycalandar.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_tasksList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val taskList = listOf(
            Task("Arroser les plantes", "Vendredi 02 Octobre 18h"),
            Task("Répondre aux mails", "Mardi 18 Octobre 9h30")
        )

        recyclerView.adapter = TaskAdapter(taskList) { task ->
            val intent = Intent(this, TaskDetailsActivity::class.java)
            startActivity(intent)
        }

        val addMenuButton: FloatingActionButton = findViewById(R.id.btn_addTask)
        addMenuButton.setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}