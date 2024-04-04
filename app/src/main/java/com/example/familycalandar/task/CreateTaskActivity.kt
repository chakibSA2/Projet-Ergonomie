package com.example.familycalandar.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R

class CreateTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        val toolbar = findViewById<Toolbar>(R.id.tb_taskCreateToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, TasksListActivity::class.java)
            startActivity(intent)
        }

    }
}