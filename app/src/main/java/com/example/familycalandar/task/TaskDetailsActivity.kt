package com.example.familycalandar.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val toolbar = findViewById<Toolbar>(R.id.tb_taskDetailsToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, TasksListActivity::class.java)
            startActivity(intent)
        }
    }
}