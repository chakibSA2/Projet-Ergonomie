package com.example.familycalandar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val traveler: Button = findViewById(R.id.btn_TravelerDashboard)
        traveler.setOnClickListener {
            val intent = Intent(this, MainboardVoyageurActivity::class.java)
            startActivity(intent)
        }

        val parent : Button = findViewById(R.id.btn_FamilyDashboard)
        parent.setOnClickListener {
            val intent = Intent(this, MainboardParentsActivity::class.java)
            startActivity(intent)
        }

        val association : Button = findViewById(R.id.btn_AssociationDashboard)
        association.setOnClickListener {
            val intent = Intent(this, MainboardAssociationActivity::class.java)
            startActivity(intent)
        }

        val student : Button = findViewById(R.id.btn_StudentDashboard)
        student.setOnClickListener {
            val intent = Intent(this, MainboardEtudiantActivity::class.java)
            startActivity(intent)
        }

        val default : Button = findViewById(R.id.btn_DefaultDashboard)
        default.setOnClickListener {
            val intent = Intent(this, MainboardUserGeneralActivity::class.java)
            startActivity(intent)
        }

    }
}