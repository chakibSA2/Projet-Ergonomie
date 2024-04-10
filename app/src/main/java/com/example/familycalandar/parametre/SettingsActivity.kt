package com.example.familycalandar.parametre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.example.familycalandar.MainActivity
import com.example.familycalandar.MainboardAssociationActivity
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R
import com.example.familycalandar.menu.MenuViewActivity
import com.example.familycalandar.task.TasksListActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toolbar = findViewById<Toolbar>(R.id.settings_Toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainboardVoyageurActivity::class.java)
            startActivity(intent)
        }

        val changeProfil: Button = findViewById(R.id.changeProfil)
        changeProfil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val changePin : Button = findViewById(R.id.changePinButton)
        changePin.setOnClickListener {
            val intent = Intent(this, ChangePinActivity::class.java)
            startActivity(intent)
        }

        val btnShare = findViewById<Button>(R.id.ShareItem)
        btnShare.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            startActivity(intent)
        }
    }
}