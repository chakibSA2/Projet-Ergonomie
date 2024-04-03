package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.familycalandar.task.TasksListActivity
import com.example.familycalandar.toDoList.ToDoListActivity

class MainboardParentsActivity : AppCompatActivity() {
    private lateinit var btnParametres: Button;
    private lateinit var btnGestionMenus: Button;
    private lateinit var btnListeCourses: Button;
    private lateinit var btnEmploiTemps: Button;
    private lateinit var btnVoyage: Button;
    private lateinit var btnDocuments: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainboard_parents)

        val toDo : CardView = findViewById(R.id.vgn_ToDoVignette)
        toDo.setOnClickListener {
            val intent = Intent(this, ToDoListActivity::class.java)
            startActivity(intent)
        }
    }
}