package com.example.familycalandar.courses

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.familycalandar.MainboardParentsActivity
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        val toolbar = findViewById<Toolbar>(R.id.tlb_CoursesListToolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainboardVoyageurActivity::class.java)
            startActivity(intent)
        }
    }

}