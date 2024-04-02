package com.example.familycalandar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerRecettes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_recettes)

        val recettesList = listOf(
            RecetteModel("Recette 1", "Description de la recette 1"),
            RecetteModel("Recette 2", "Description de la recette 2"),
            RecetteModel("Recette 1", "Description de la recette 1"),
            RecetteModel("Recette 2", "Description de la recette 2"),

            )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecetteAdapter(recettesList)

        val creatrecepi: Button = findViewById(R.id.fab_add)
        creatrecepi.setOnClickListener {
            val intent = Intent(this, CreatRecetteActivity::class.java)
            startActivity(intent)
        }
    }
}
