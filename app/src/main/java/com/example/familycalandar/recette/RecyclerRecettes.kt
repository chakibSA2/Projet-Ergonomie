package com.example.familycalandar.recette

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.familycalandar.R
import com.example.familycalandar.menu.ViewMenuActivity
import com.example.familycalandar.travel.TravelsListViewActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerRecettes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_recettes)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, TravelsListViewActivity::class.java)
            startActivity(intent)
        }

        val recettesList = listOf(
            RecetteModel("Patte carbonara", "délicieuse patte a la carbo"),
            RecetteModel("pomme de terre sauté ", "légere pomme de terre sauté"),
            RecetteModel("chebakia", "le diabet a l'etat pure"),
            RecetteModel("kebab", "salade tomate ognion"),

            )


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecetteAdapter(recettesList) { recette->
            val intent = Intent(this, ViewMenuActivity::class.java)
            startActivity(intent)
        }

        val creatrecepi: FloatingActionButton = findViewById(R.id.fab_add)
        creatrecepi.setOnClickListener {
            val intent = Intent(this, CreatRecetteActivity::class.java)
            startActivity(intent)
        }

        recyclerView.adapter = RecetteAdapter(recettesList) {  recette ->
            val intent = Intent(this, Details_recette_activity::class.java)
            startActivity(intent)
        }
    }

    }

