package com.example.familycalandar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.familycalandar.menu.MenuViewActivity
import com.example.familycalandar.parametre.SettingsActivity
import com.example.familycalandar.task.TasksListActivity

class MainboardAssociationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainboard_association)

        val tasks: CardView = findViewById(R.id.vgn_TasksVignette)
        tasks.setOnClickListener {
            val intent = Intent(this, TasksListActivity::class.java)
            startActivity(intent)
        }

        val menus : CardView = findViewById(R.id.vgn_MenusVignette)
        menus.setOnClickListener {
            val intent = Intent(this, MenuViewActivity::class.java)
            startActivity(intent)
        }

        val settings : CardView = findViewById(R.id.vgn_ParametersVignette)
        settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}