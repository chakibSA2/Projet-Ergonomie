package com.example.familycalandar.recette

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.familycalandar.R

class CreatRecetteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creat_recettes)

        val valider: Button = findViewById(R.id.valider)
        valider.setOnClickListener {
            // Retourne à l'activité précédente
            finish()
        }
    }
}

