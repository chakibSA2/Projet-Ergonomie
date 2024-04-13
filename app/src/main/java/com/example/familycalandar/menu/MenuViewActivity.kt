package com.example.familycalandar.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.MainboardParentsActivity
import com.example.familycalandar.MainboardVoyageurActivity
import com.example.familycalandar.R
import com.example.familycalandar.document.DocumentModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MenuViewActivity : AppCompatActivity() {
    private lateinit var menuList : MutableList<MenuModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainboardVoyageurActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.menuRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        menuList = mutableListOf(MenuModel("Menu 1", "Vendredi 12h"), MenuModel("Menu 2", "Samedi 20h"))

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