package com.example.familycalandar.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MenuViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        val recyclerView = findViewById<RecyclerView>(R.id.menuRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val menuList = listOf(MenuModel("Menu 1", "Vendredi 12h"), MenuModel("Menu 2", "Samedi 20h"))

        recyclerView.adapter = MenuAdapter(menuList) { menu ->
            val intent = Intent(this, ViewMenuActivity::class.java)
            startActivity(intent)
        }

        val addMenuButton: FloatingActionButton = findViewById(R.id.addMenuButton)
        addMenuButton.setOnClickListener {
            val intent = Intent(this, CreateMenuActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}